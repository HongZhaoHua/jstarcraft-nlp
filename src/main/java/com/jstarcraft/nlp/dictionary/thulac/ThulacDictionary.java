package com.jstarcraft.nlp.dictionary.thulac;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

import io.github.yizhiru.thulac4j.common.DoubleArrayTrie;

/**
 * THULAC词典
 * https://github.com/yizhiru/thulac4j/blob/137c022ab476a9177f41c26a904719d18e599fa9/src/test/java/io/github/yizhiru/thulac4j/common/DoubleArrayTrieTest.java
 * 
 * @author Birdy
 *
 */
public class ThulacDictionary implements NlpDictionary {

    private DoubleArrayTrie trie;

    public ThulacDictionary(DoubleArrayTrie trie) {
        this.trie = trie;
    }

    @Override
    public boolean contain(String text) {
        return trie.isWordMatched(text);
    }

}
