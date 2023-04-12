package com.jstarcraft.nlp.dictionary;

import com.jstarcraft.nlp.dictionary.corenlp.CorenlpDictionary;

import edu.stanford.nlp.ling.tokensregex.matcher.TrieMap;

public class CorenlpDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        TrieMap<String, Boolean> trie = new TrieMap<>();
        for (String text : texts) {
            trie.put(new String[] { text }, true);
        }
        CorenlpDictionary dictionary = new CorenlpDictionary(trie);
        return dictionary;
    }

}
