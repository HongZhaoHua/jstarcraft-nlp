package com.jstarcraft.nlp.detection;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;

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
            Assertions.assertEquals(size, regulations.size());
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
            Assertions.assertEquals(size, dictionaries.size());
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    /**
     * 测试已知语种
     */
    @Test
    public void testKnowedLanguage() {
        LanguageDetector detector = new LanguageDetector(DetectionPattern.LANGUAGE_187, DetectionTrie.LANGUAGE_187);
        Assertions.assertEquals("eng", detector.detectLanguage("The goal is to provide a general Java core programming framework").getLocale().toLanguageTag());
        Assertions.assertEquals("cmn", detector.detectLanguage("目标是提供一个通用的Java核心编程框架").getLocale().toLanguageTag());
        Assertions.assertEquals("fra", detector.detectLanguage("L'objectif est de fournir un cadre de programmation de base commun pour Java").getLocale().toLanguageTag());
        Assertions.assertEquals("spa", detector.detectLanguage("El objetivo es ofrecer un marco común de programación básica Java").getLocale().toLanguageTag());
        Assertions.assertEquals("por", detector.detectLanguage("O objetivo é fornecer um Quadro geral de programação do núcleo Java").getLocale().toLanguageTag());
        Assertions.assertEquals("rus", detector.detectLanguage("Цель заключается в том, чтобы создать общую базу программирования Java").getLocale().toLanguageTag());
        Assertions.assertEquals("arb", detector.detectLanguage("الهدف هو توفير إطار البرمجة جافا الأساسية المشتركة").getLocale().toLanguageTag());
        Assertions.assertEquals("deu", detector.detectLanguage("Das Ziel ist es, einen allgemeinen Java-Core-Programmrahmen bereitzustellen").getLocale().toLanguageTag());
        Assertions.assertEquals("jpn", detector.detectLanguage("目標は汎用Javaコアプログラミングフレームを提供することです。").getLocale().toLanguageTag());
        Assertions.assertEquals("hin", detector.detectLanguage("लक्ष्य यह है कि सामान्य जावा कोर प्रोग्रामिंग फ्रेमवर्क प्रदान करना है").getLocale().toLanguageTag());
    }

    /**
     * 测试未知语种
     */
    @Test
    public void testUnknowedLanguage() {
        LanguageDetector detector = new LanguageDetector(DetectionPattern.LANGUAGE_187, DetectionTrie.LANGUAGE_187);
        {
            // 指定白名单
            Object2BooleanMap<String> options = new Object2BooleanOpenHashMap<>();
            options.put("eng", true);
            DetectionLanguage language = detector.detectLanguage("目标是提供一个通用的Java核心编程框架", options);
            Assertions.assertNull(language);
        }
        {
            // 指定黑名单
            Object2BooleanMap<String> options = new Object2BooleanOpenHashMap<>();
            options.put("cmn", false);
            DetectionLanguage language = detector.detectLanguage("目标是提供一个通用的Java核心编程框架", options);
            Assertions.assertNull(language);
        }
    }

}
