package com.jstarcraft.nlp.dictionary.word;

import org.apdplat.word.dictionary.Dictionary;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * word词典
 * https://github.com/ysc/word#5%E8%87%AA%E5%AE%9A%E4%B9%89%E7%94%A8%E6%88%B7%E8%AF%8D%E5%BA%93
 * 
 * @author Birdy
 *
 */
public class WordDictionary implements NlpDictionary {

    private Dictionary dictionary;

    public WordDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean contain(String text) {
        return dictionary.contains(text);
    }

}
