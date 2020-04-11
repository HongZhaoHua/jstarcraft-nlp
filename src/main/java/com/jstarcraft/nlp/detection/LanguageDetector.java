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

import it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap;
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

    private final static int DEFAULT_MINIMUM = 0;

    private final static int DEFAULT_MAXIMUM = 1024;

    private final static int DEFAULT_DIFFERENCE = 300;

    private final static Object2BooleanMap<String> DEFAULT_OPTIONS = new Object2BooleanArrayMap<>(0);

    private final static Pattern REPLACE = Pattern.compile("[\\u0021-\\u0040\\s]+");

    /** 检测规则 */
    private Map<String, DetectionPattern> patterns;

    /** 检测词典 */
    private Map<String, Set<DetectionTrie>> tires;

    private int minimum;

    private int maximum;

    public LanguageDetector(Map<String, DetectionPattern> patterns, Map<String, Set<DetectionTrie>> tires) {
        this(patterns, tires, DEFAULT_MINIMUM, DEFAULT_MAXIMUM);
    }

    public LanguageDetector(Map<String, DetectionPattern> patterns, Map<String, Set<DetectionTrie>> tires, int minimum, int maximum) {
        this.patterns = patterns;
        this.tires = tires;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     * 检测语言
     * 
     * @param text
     * @return
     */
    public DetectionLanguage detectLanguage(String text) {
        return detectLanguage(text, DEFAULT_OPTIONS);
    }

    /**
     * 检测语言
     * 
     * @param text
     * @param options
     * @return
     */
    public DetectionLanguage detectLanguage(String text, Object2BooleanMap<String> options) {
        SortedSet<DetectionLanguage> locales = detectLanguages(text, options);
        return locales.isEmpty() ? null : locales.first();
    }

    /**
     * 检查语言
     * 
     * @param language
     * @param writes
     * @param blacks
     * @return
     */
    private boolean checkLanguage(String language, Set<String> writes, Set<String> blacks) {
        if (writes.isEmpty() && blacks.isEmpty()) {
            return true;
        }
        return writes.contains(language) && !blacks.contains(language);
    }

    /**
     * 获取得分
     * 
     * @param tuples
     * @param trie
     * @return
     */
    private double getScore(Object2IntMap<CharSequence> tuples, ITrie<Integer> trie) {
        double score = 0D;
        Integer difference;
        for (Object2IntMap.Entry<CharSequence> tuple : tuples.object2IntEntrySet()) {
            difference = trie.get(tuple.getKey().toString());
            if (difference == null) {
                difference = DEFAULT_DIFFERENCE;
            } else {
                difference = tuple.getIntValue() - difference - 1;
                if (difference < 0) {
                    difference = -difference;
                }
            }
            score += difference;
        }
        return score;
    }

    /**
     * 归一化得分
     * 
     * @param text
     * @param locales
     */
    private void normalizeScores(String text, SortedSet<DetectionLanguage> locales) {
        double minimum = locales.first().getScore();
        double maximum = text.length() * DEFAULT_DIFFERENCE - minimum;
        for (DetectionLanguage locale : locales) {
            double score = locale.getScore();
            score = 1 - (score - minimum) / maximum;
            locale.setScore(score);
        }
    }

    /**
     * 检测语言
     * 
     * @param text
     * @return
     */
    public SortedSet<DetectionLanguage> detectLanguages(String text) {
        return detectLanguages(text, DEFAULT_OPTIONS);
    }

    /**
     * 检测语言
     * 
     * @param text
     * @param options
     * @return
     */
    public SortedSet<DetectionLanguage> detectLanguages(String text, Object2BooleanMap<String> options) {
        SortedSet<DetectionLanguage> locales = new TreeSet<>();

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
        Set<DetectionTrie> dictionaries = tires.get(script);
        if (dictionaries == null) {
            /*
             * If no matches occured, such as a digit only string, or because the language is ignored, exit with `und`.
             */
            if (!checkLanguage(script, writes, blacks)) {
                return locales;
            }
            locales.add(new DetectionLanguage(Locale.forLanguageTag(script), 1D));
            return locales;
        }

        /*
         * Get all distances for a given script, and normalize the distance values.
         */
        text = REPLACE.matcher(text).replaceAll(StringUtility.SPACE).toLowerCase();
        CharacterNgram ngram = new CharacterNgram(3, text);
        Object2IntMap<CharSequence> tuples = new Object2IntOpenHashMap<>();
        for (CharSequence character : ngram) {
            count = tuples.getInt(character);
            tuples.put(character, count + 1);
        }
        for (DetectionTrie dictionary : dictionaries) {
            String language = dictionary.getName();
            if (checkLanguage(language, writes, blacks)) {
                double score = getScore(tuples, dictionary.getTrie());
                DetectionLanguage locale = new DetectionLanguage(Locale.forLanguageTag(language), score);
                locales.add(locale);
            }
        }
        if (!locales.isEmpty()) {
            normalizeScores(text, locales);
        }
        return locales;
    }

}
