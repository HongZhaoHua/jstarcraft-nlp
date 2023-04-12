package com.jstarcraft.nlp.dictionary.hanlp;

import com.hankcs.hanlp.collection.trie.ITrie;
import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * HanLP词典
 * 
 * <pre>
 * https://github.com/hankcs/HanLP#8-%E7%94%A8%E6%88%B7%E8%87%AA%E5%AE%9A%E4%B9%89%E8%AF%8D%E5%85%B8 https://github.com/hankcs/HanLP#%E8%AF%8D%E5%85%B8%E8%AF%B4%E6%98%8E
 * </pre>
 * 
 * @author Birdy
 *
 */
public class HanlpDictionary implements NlpDictionary {

    private ITrie<?> trie;

    public HanlpDictionary(ITrie<?> trie) {
        this.trie = trie;
    }

    @Override
    public boolean contain(String text) {
        return trie.containsKey(text);
    }

}
