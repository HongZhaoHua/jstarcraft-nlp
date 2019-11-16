package com.jstarcraft.nlp.dictionary;

import java.util.Arrays;

import org.apdplat.word.dictionary.impl.DoubleArrayDictionaryTrie;

import com.jstarcraft.nlp.dictionary.word.WordDictionary;

public class WordDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        DoubleArrayDictionaryTrie trie = new DoubleArrayDictionaryTrie();
        trie.addAll(Arrays.asList(texts));
        WordDictionary dictionary = new WordDictionary(trie);
        return dictionary;
    }

}
