package com.jstarcraft.nlp.detection;

import com.hankcs.hanlp.collection.trie.ITrie;

/**
 * 检测词典
 * 
 * @author Birdy
 *
 */
public class DetectionTire {

    private String name;

    private ITrie<Integer> dictionary;

    DetectionTire(String name, ITrie<Integer> trie) {
        this.name = name;
        this.dictionary = trie;
    }

    public String getName() {
        return name;
    }

    public ITrie<Integer> getTrie() {
        return dictionary;
    }

}
