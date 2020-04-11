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

    private final static int DEFAULT_MAXIMUM = 2048;

    private final static int DEFAULT_MINIMUM = 10;

    private final static int DEFAULT_DIFFERENCE = 300;

    /** 检测规则 */
    private Map<String, DetectionPattern> patterns;

    /** 检测词典 */
    private Map<String, Set<DetectionTire>> tires;

    private int maximum;

    private int minimum;

    public LanguageDetector(Map<String, DetectionPattern> patterns, Map<String, Set<DetectionTire>> tires) {
        this(patterns, tires, DEFAULT_MAXIMUM, DEFAULT_MINIMUM);
    }

    public LanguageDetector(Map<String, DetectionPattern> patterns, Map<String, Set<DetectionTire>> tires, int maximum, int minimum) {
        this.patterns = patterns;
        this.tires = tires;
        this.maximum = maximum;
        this.minimum = minimum;
    }

    /**
     * 检测语言
     * 
     * @param text
     * @param options
     * @return
     */
    public LocaleLanguage detectLanguage(String text, Object2BooleanMap<String> options) {
        SortedSet<LocaleLanguage> locales = detectLanguages(text, options);
        return locales.isEmpty() ? null : locales.first();
    }

    /**
     * 检验语言
     * 
     * @param language
     * @param writes
     * @param blacks
     * @return
     */
    boolean checkLanguage(String language, Set<String> writes, Set<String> blacks) {
        if (writes.isEmpty() && blacks.isEmpty()) {
            return true;
        }
        return writes.contains(language) && !blacks.contains(language);
    }

    double getScore(Object2IntMap<CharSequence> tuples, ITrie<Integer> trie) {
        double score = 0D;
        Integer difference;
        for (Object2IntMap.Entry<CharSequence> tuple : tuples.object2IntEntrySet()) {
            difference = trie.get(tuple.getKey().toString());
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

    void normalizeScores(String text, SortedSet<LocaleLanguage> locales) {
        double minimum = locales.first().getScore();
        double maximum = text.length() * DEFAULT_DIFFERENCE - minimum;
        for (LocaleLanguage locale : locales) {
            double score = locale.getScore();
            score = 1 - (score - minimum) / maximum;
            locale.setScore(score);
        }
    }

    /**
     * 检测语言
     * 
     * @param text
     * @param options
     * @return
     */
    public SortedSet<LocaleLanguage> detectLanguages(String text, Object2BooleanMap<String> options) {
        SortedSet<LocaleLanguage> locales = new TreeSet<>();

        // 白名单,黑名单
        HashSet<String> writes = new HashSet<>();
        HashSet<String> blacks = new HashSet<>();
        for (Object2BooleanMap.Entry<String> option : options.object2BooleanEntrySet()) {
            if (option.getBooleanValue()) {
                writes.add(option.getKey());
            } else {
                blacks.add(option.getKey());
            }
        }

        int size = text.length();
        if (size < minimum) {
            return locales;
        }
        if (size > maximum) {
            text = text.substring(0, maximum);
            size = maximum;
        }

        /*
         * Get the script which characters occur the most in `value`.
         */
        int count = -1;
        String script = null;
        for (DetectionPattern regulation : patterns.values()) {
            Pattern pattern = regulation.getPattern();
            Matcher matcher = pattern.matcher(text);
            int match = 0;
            while (matcher.find()) {
                match++;
            }
            if (match > count) {
                count = match;
                script = regulation.getName();
            }
        }
        if (script == null || count <= 0) {
            return locales;
        }

        /* One languages exists for the most-used script. */
        Set<DetectionTire> dictionaries = tires.get(script);
        if (dictionaries == null) {
            /*
             * If no matches occured, such as a digit only string, or because the language is ignored, exit with `und`.
             */
            if (!checkLanguage(script, writes, blacks)) {
                return locales;
            }
            locales.add(new LocaleLanguage(Locale.forLanguageTag(script), 1D));
            return locales;
        }

        /*
         * Get all distances for a given script, and normalize the distance values.
         */
        text = replace.matcher(text).replaceAll(StringUtility.SPACE);
        CharacterNgram ngram = new CharacterNgram(3, text);
        Object2IntMap<CharSequence> tuples = new Object2IntOpenHashMap<>();
        for (CharSequence character : ngram) {
            count = tuples.getInt(character);
            tuples.put(character, count + 1);
        }
        for (DetectionTire dictionary : dictionaries) {
            String language = dictionary.getName();
            if (checkLanguage(language, writes, blacks)) {
                double score = getScore(tuples, dictionary.getTrie());
                LocaleLanguage locale = new LocaleLanguage(Locale.forLanguageTag(language), score);
                locales.add(locale);
            }
        }
        if (!locales.isEmpty()) {
            normalizeScores(text, locales);
        }
        return locales;
    }

}