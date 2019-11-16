package com.jstarcraft.nlp.dictionary;

import java.util.Arrays;

import com.jstarcraft.nlp.dictionary.thulac.ThulacDictionary;

import io.github.yizhiru.thulac4j.common.DoubleArrayTrie;

public class ThulacDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        DoubleArrayTrie trie = DoubleArrayTrie.make(Arrays.asList(texts));
        ThulacDictionary dictionary = new ThulacDictionary(trie);
        return dictionary;
    }

}
