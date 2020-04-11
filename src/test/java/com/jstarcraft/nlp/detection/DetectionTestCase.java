package com.jstarcraft.nlp.detection;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DetectionTestCase {

    /**
     * 测试装载语种检测规则
     * 
     * @param path
     * @param size
     */
    @ParameterizedTest
    @CsvSource({ "regulation-82.json,20", "regulation-187.json,30", "regulation-406.json,37" })
    public void testLoadPattern(String path, int size) {
        try (InputStream stream = DetectionPattern.class.getResourceAsStream(path)) {
            Map<String, DetectionPattern> regulations = DetectionPattern.loadPatterns(stream);
            Assert.assertEquals(size, regulations.size());
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    /**
     * 测试装载语种检测词典
     * 
     * @param path
     * @param size
     */
    @ParameterizedTest
    @CsvSource({ "dictionary-82.json,4", "dictionary-187.json,7", "dictionary-406.json,10" })
    public void testLoadTrie(String path, int size) {
        try (InputStream stream = DetectionTrie.class.getResourceAsStream(path)) {
            Map<String, Set<DetectionTrie>> dictionaries = DetectionTrie.loadTries(stream);
            Assert.assertEquals(size, dictionaries.size());
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    @Test
    public void testDetectLanguage() {
        LanguageDetector detector = new LanguageDetector(DetectionPattern.LANGUAGE_187, DetectionTrie.LANGUAGE_187);

        System.out.println(detector.detectLanguage("目标是提供一个通用的Java核心编程框架,作为搭建其它框架或者项目的基础."));
        System.out.println(detector.detectLanguage("Alle menslike wesens word vry"));
        System.out.println(detector.detectLanguage("এটি একটি ভাষা একক IBM স্ক্রিপ্ট"));
        System.out.println(detector.detectLanguage("Alle menneske er fødde til fridom"));
        System.out.println(detector.detectLanguage(""));
        System.out.println(detector.detectLanguage("the"));
    }

}
