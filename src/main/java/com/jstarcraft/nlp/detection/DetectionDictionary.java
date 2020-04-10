package com.jstarcraft.nlp.detection;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * 检测词典
 * 
 * @author Birdy
 *
 */
public class DetectionDictionary {

    private String name;

    private NlpDictionary dictionary;

    DetectionDictionary(String name, NlpDictionary dictionary) {
        this.name = name;
        this.dictionary = dictionary;
    }

}
