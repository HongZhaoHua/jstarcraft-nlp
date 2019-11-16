package com.jstarcraft.nlp.dictionary;

import java.util.TreeMap;

import com.jstarcraft.nlp.dictionary.mynlp.MynlpDictionary;
import com.mayabot.nlp.collection.dat.DoubleArrayTrieStringIntMap;

public class MynlpDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        for (String text : texts) {
            tree.put(text, 0);
        }
        DoubleArrayTrieStringIntMap trie = new DoubleArrayTrieStringIntMap(tree);
        MynlpDictionary dictionary = new MynlpDictionary(trie);
        return dictionary;
    }

}
