package com.jstarcraft.nlp.dictionary.corenlp;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

import edu.stanford.nlp.ling.tokensregex.matcher.TrieMap;

/**
 * CoreNLP词典
 * 
 * <pre>
 * https://github.com/stanfordnlp/CoreNLP/blob/eb43d5d9150de97f8061fa06b838f1d021586789/test/src/edu/stanford/nlp/ling/tokensregex/matcher/TrieMapTest.java
 * </pre>
 * 
 * @author Birdy
 *
 */
public class CorenlpDictionary implements NlpDictionary {

    private TrieMap<String, ?> trie;

    public CorenlpDictionary(TrieMap<String, ?> trie) {
        this.trie = trie;
    }

    @Override
    public boolean contain(String text) {
        return trie.containsKey(new String[] { text });
    }

}
