package com.jstarcraft.nlp;

import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment;

public class HanlpDictionaryTrieSegment extends DoubleArrayTrieSegment {

    public HanlpDictionaryTrieSegment(DoubleArrayTrie<CoreDictionary.Attribute> trie) {
        super(trie);
    }

    protected void posTag(char[] charArray, int[] wordNet, Nature[] natureArray) {
    }
}
