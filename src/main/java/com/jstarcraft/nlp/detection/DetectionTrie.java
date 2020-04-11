package com.jstarcraft.nlp.detection;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.ITrie;
import com.jstarcraft.core.common.conversion.json.JsonUtility;
import com.jstarcraft.core.common.reflection.TypeUtility;
import com.jstarcraft.core.utility.StringUtility;

/**
 * 检测词典
 * 
 * @author Birdy
 *
 */
public class DetectionTrie {

    public final static Map<String, Set<DetectionTrie>> LANGUAGE_82;

    public final static Map<String, Set<DetectionTrie>> LANGUAGE_187;

    public final static Map<String, Set<DetectionTrie>> LANGUAGE_406;

    static {
        try {
            try (InputStream stream = DetectionPattern.class.getResourceAsStream("dictionary-82.json")) {
                LANGUAGE_82 = loadTries(stream);
            }
            try (InputStream stream = DetectionPattern.class.getResourceAsStream("dictionary-187.json")) {
                LANGUAGE_187 = loadTries(stream);
            }
            try (InputStream stream = DetectionPattern.class.getResourceAsStream("dictionary-406.json")) {
                LANGUAGE_406 = loadTries(stream);
            }
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    private String name;

    private ITrie<Integer> dictionary;

    public DetectionTrie(String name, ITrie<Integer> trie) {
        this.name = name;
        this.dictionary = trie;
    }

    public String getName() {
        return name;
    }

    public ITrie<Integer> getTrie() {
        return dictionary;
    }

    public static final Map<String, Set<DetectionTrie>> loadTries(InputStream stream) {
        try (DataInputStream buffer = new DataInputStream(stream)) {
            Map<String, Set<DetectionTrie>> detections = new HashMap<>();
            byte[] data = new byte[buffer.available()];
            buffer.readFully(data);
            String json = new String(data, StringUtility.CHARSET);
            // 兼容\x转义ASCII字符
            json = StringUtility.unescapeJava(json);
            Type type = TypeUtility.parameterize(LinkedHashMap.class, String.class, String.class);
            type = TypeUtility.parameterize(LinkedHashMap.class, String.class, LinkedHashMap.class);
            LinkedHashMap<String, LinkedHashMap<String, String>> dictionaries = JsonUtility.string2Object(json, type);

            for (Entry<String, LinkedHashMap<String, String>> scriptTerm : dictionaries.entrySet()) {
                Set<DetectionTrie> tries = new HashSet<>();
                String script = scriptTerm.getKey();
                LinkedHashMap<String, String> languages = scriptTerm.getValue();
                for (Entry<String, String> languageTerm : languages.entrySet()) {
                    String language = languageTerm.getKey();
                    String[] dictionary = languageTerm.getValue().split("\\|");
                    int weight = 0;
                    TreeMap<String, Integer> tree = new TreeMap<>();
                    for (String word : dictionary) {
                        tree.put(word, weight++);
                    }
                    DoubleArrayTrie<Integer> trie = new DoubleArrayTrie<>(tree);
                    DetectionTrie detection = new DetectionTrie(language, trie);
                    tries.add(detection);
                }
                detections.put(script, Collections.unmodifiableSet(tries));
            }
            return Collections.unmodifiableMap(detections);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

}
