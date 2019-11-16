package com.jstarcraft.nlp.dictionary;

import java.util.TreeMap;

import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.ITrie;
import com.jstarcraft.nlp.dictionary.hanlp.HanLpDictionary;

public class HanLpDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        ITrie<Object> trie = new DoubleArrayTrie<>();
        TreeMap<String, Object> tree = new TreeMap<>();
        for (String text : texts) {
            tree.put(text, null);
        }
        trie.build(tree);
        HanLpDictionary dictionary = new HanLpDictionary(trie);
        return dictionary;
    }

}
