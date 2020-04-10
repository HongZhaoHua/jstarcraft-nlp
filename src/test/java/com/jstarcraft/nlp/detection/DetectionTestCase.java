package com.jstarcraft.nlp.detection;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.ITrie;
import com.jstarcraft.core.common.conversion.json.JsonUtility;
import com.jstarcraft.core.common.reflection.TypeUtility;
import com.jstarcraft.core.utility.StringUtility;
import com.jstarcraft.nlp.dictionary.hanlp.HanLpDictionary;

public class DetectionTestCase {

    /**
     * 测试装载语种检测词典
     * 
     * @param path
     * @param size
     */
    @ParameterizedTest
    @CsvSource({ "dictionary-82.json,4", "dictionary-187.json,10", "dictionary-406.json,10" })
    public void testLoadDictionary(String path, int size) {
        try (InputStream stream = DetectionDictionary.class.getResourceAsStream(path); DataInputStream buffer = new DataInputStream(stream)) {
            byte[] data = new byte[buffer.available()];
            buffer.readFully(data);
            String json = new String(data, StringUtility.CHARSET);
            // 兼容\x转义ASCII字符
            json = StringEscapeUtils.unescapeJava(json);
            Type type = TypeUtility.parameterize(LinkedHashMap.class, String.class, String.class);
            type = TypeUtility.parameterize(LinkedHashMap.class, String.class, LinkedHashMap.class);
            LinkedHashMap<String, LinkedHashMap<String, String>> dictionaries = JsonUtility.string2Object(json, type);
            Assert.assertEquals(size, dictionaries.size());

            for (Entry<String, LinkedHashMap<String, String>> scriptTerm : dictionaries.entrySet()) {
                String script = scriptTerm.getKey();
                LinkedHashMap<String, String> languages = scriptTerm.getValue();
                for (Entry<String, String> languageTerm : languages.entrySet()) {
                    String language = languageTerm.getKey();
                    String[] words = languageTerm.getValue().split("|");
                    ITrie<Object> trie = new DoubleArrayTrie<>();
                    TreeMap<String, Object> tree = new TreeMap<>();
                    for (String word : words) {
                        tree.put(word, null);
                    }
                    trie.build(tree);
                    HanLpDictionary dictionary = new HanLpDictionary(trie);
                    DetectionDictionary detection = new DetectionDictionary(language, dictionary);
                }
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    /**
     * 测试装载语种检测规则
     * 
     * @param path
     * @param size
     */
    @ParameterizedTest
    @CsvSource({ "regulation-82.json,20", "regulation-187.json,37", "regulation-406.json,37" })
    public void testLoadRegulation(String path, int size) {
        try (InputStream stream = DetectionRegulation.class.getResourceAsStream(path); DataInputStream buffer = new DataInputStream(stream)) {
            byte[] data = new byte[buffer.available()];
            buffer.readFully(data);
            String json = new String(data, StringUtility.CHARSET);
            // 兼容\x转义ASCII字符
            json = StringEscapeUtils.unescapeJava(json);
            Type type = TypeUtility.parameterize(LinkedHashMap.class, String.class, String.class);
            LinkedHashMap<String, String> regulations = JsonUtility.string2Object(json, type);
            Assert.assertEquals(size, regulations.size());

            for (Entry<String, String> languageTerm : regulations.entrySet()) {
                String language = languageTerm.getKey();
                String regulation = languageTerm.getValue();
                Pattern pattern = Pattern.compile(regulation, Pattern.MULTILINE);
                DetectionRegulation detection = new DetectionRegulation(language, pattern);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

}
