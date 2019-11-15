package com.jstarcraft.nlp.dictionary.mynlp;

import com.jstarcraft.nlp.dictionary.NlpDictionary;
import com.mayabot.nlp.collection.dat.DoubleArrayTrieStringIntMap;

/**
 * https://github.com/mayabot/mynlp/wiki/CustomDict
 * 
 * @author Birdy
 *
 */
public class MynlpDictionary implements NlpDictionary {

    private DoubleArrayTrieStringIntMap trie;

    public MynlpDictionary(DoubleArrayTrieStringIntMap trie) {
        this.trie = trie;
    }

    @Override
    public boolean contain(String text) {
        return trie.containsKey(text);
    }

}
