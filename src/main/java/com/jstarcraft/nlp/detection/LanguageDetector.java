package com.jstarcraft.nlp.detection;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hankcs.hanlp.collection.trie.ITrie;
import com.jstarcraft.ai.math.algorithm.text.CharacterNgram;
import com.jstarcraft.core.utility.KeyValue;
import com.jstarcraft.core.utility.StringUtility;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

/**
 * 语言检测器
 * 
 * @author Birdy
 *
 */
public class LanguageDetector {

    private final static Pattern replace = Pattern.compile("[\\u0021-\\u0040\\s]+");

    /* Maximum sample length. */
    private final static int DEFAULT_MAXIMUM = 2048;

    /* Minimum sample length. */
    private final static int DEFAULT_MINIMUM = 10;

    /*
     * The maximum distance to add when a given trigram does not exist in a trigram
     * dictionary.
     */
    private final static int DEFAULT_DIFFERENCE = 300;

    /** 检测词典 */
    private Map<String, Set<DetectionTire>> dictionaries;

    /** 检测规则 */
    private Map<String, DetectionPattern> regulations;

    private int maximum;

    private int minimum;

    private int difference;

    public LanguageDetector(Map<String, Set<DetectionTire>> dictionaries, Map<String, DetectionPattern> regulations) {
        this(dictionaries, regulations, DEFAULT_MAXIMUM, DEFAULT_MINIMUM, DEFAULT_DIFFERENCE);
    }

    public LanguageDetector(Map<String, Set<DetectionTire>> dictionaries, Map<String, DetectionPattern> regulations, int maximum, int minimum) {
        this(dictionaries, regulations, maximum, minimum, DEFAULT_DIFFERENCE);
    }

    public LanguageDetector(Map<String, Set<DetectionTire>> dictionaries, Map<String, DetectionPattern> regulations, int maximum, int minimum, int difference) {
        this.dictionaries = dictionaries;
        this.regulations = regulations;
        this.maximum = maximum;
        this.minimum = minimum;
        this.difference = difference;
    }

    public LocaleLanguage detectLanguage(String text, Object2BooleanMap<Locale> options) {
        return null;
    }

    KeyValue<String, Integer> getScript(String text) {
        int count = -1;
        String script = null;

        for (DetectionPattern regulation : regulations.values()) {
            Pattern pattern = regulation.getPattern();
            Matcher matcher = pattern.matcher(text);
            int occurrence = 0;
            while (matcher.find()) {
                occurrence++;
            }
            if (occurrence > count) {
                count = occurrence;
                script = regulation.getName();
            }
        }

        return new KeyValue<>(script, count);
    }

    boolean allow(String language, Set<Locale> writes, Set<Locale> blacks) {
        // TODO
        if (writes.isEmpty() && blacks.isEmpty()) {
            return true;
        }

        return writes.contains(language) && !blacks.contains(language);
    }

    double getDistance(Object2IntMap<CharSequence> tuples, ITrie<Integer> model) {
        double score = 0D;
        Integer difference;

        for (Object2IntMap.Entry<CharSequence> tuple : tuples.object2IntEntrySet()) {
            difference = model.get(tuple.getKey().toString());
            if (difference == null) {
                difference = DEFAULT_DIFFERENCE;
            }
            if (difference < 0) {
                difference = -difference;
            }
            score += difference;
        }
        return score;
    }

    void getDistances(SortedSet<LocaleLanguage> locales, Object2IntMap<CharSequence> tuples, Set<DetectionTire> languages, Set<Locale> writes, Set<Locale> blacks) {
        for (DetectionTire dictionary : languages) {
            String language = dictionary.getName();
            if (allow(language, writes, blacks)) {
                double score = getDistance(tuples, dictionary.getTrie());
                LocaleLanguage locale = new LocaleLanguage(Locale.forLanguageTag(language), score);
                locales.add(locale);
            }
        }
    }

    void normalize(String text, SortedSet<LocaleLanguage> locales) {
        double minimum = locales.first().getScore();
        double maximum = text.length() * DEFAULT_DIFFERENCE - minimum;
        for (LocaleLanguage locale : locales) {
            double score = locale.getScore();
            score = 1 - (score - minimum) / maximum;
            locale.setScore(score);
        }
    }

    public SortedSet<LocaleLanguage> detectLanguages(String text, Object2BooleanMap<Locale> options) {
        SortedSet<LocaleLanguage> locales = new TreeSet<>();

        // 白名单,黑名单
        HashSet<Locale> writes = new HashSet<>();
        HashSet<Locale> blacks = new HashSet<>();
        for (Object2BooleanMap.Entry<Locale> option : options.object2BooleanEntrySet()) {
            if (option.getBooleanValue()) {
                writes.add(option.getKey());
            } else {
                blacks.add(option.getKey());
            }
        }

        int size = text.length();
        if (size < minimum) {
            return null;
        }
        if (size > maximum) {
            text = text.substring(0, maximum);
            size = maximum;
        }

        /*
         * Get the script which characters occur the most in `value`.
         */
        KeyValue<String, Integer> script = getScript(text);
        if (script.getKey() == null || script.getValue() <= 0) {
            return locales;
        }

        /* One languages exists for the most-used script. */
        Set<DetectionTire> languages = dictionaries.get(script.getKey());
        if (languages == null) {
            /*
             * If no matches occured, such as a digit only string, or because the language
             * is ignored, exit with `und`.
             */
            if (!allow(script.getKey(), writes, blacks)) {
                return locales;
            }
            locales.add(new LocaleLanguage(Locale.forLanguageTag(script.getKey()), 1D));
            return locales;
        }

        text = replace.matcher(text).replaceAll(StringUtility.SPACE);
        CharacterNgram ngram = new CharacterNgram(3, text);
        Object2IntMap<CharSequence> tuples = new Object2IntOpenHashMap<>();
        for (CharSequence character : ngram) {
            int count = tuples.getInt(character);
            tuples.put(character, count + 1);
        }

        getDistances(locales, tuples, languages, writes, blacks);
        if (!locales.isEmpty()) {
            normalize(text, locales);
        }
        return locales;
    }

}
