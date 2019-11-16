package com.jstarcraft.nlp.dictionary;

import com.jstarcraft.nlp.dictionary.corenlp.CoreNlpDictionary;

import edu.stanford.nlp.ling.tokensregex.matcher.TrieMap;

public class CoreNlpDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        TrieMap<String, Boolean> trie = new TrieMap<>();
        for (String text : texts) {
            trie.put(new String[] { text }, true);
        }
        CoreNlpDictionary dictionary = new CoreNlpDictionary(trie);
        return dictionary;
    }

}
