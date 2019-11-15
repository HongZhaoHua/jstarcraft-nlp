package com.jstarcraft.nlp.dictionary.jcseg;

import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.ILexicon;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * https://github.com/lionsoul2014/jcseg#jcseg%E4%BA%8C%E6%AC%A1%E5%BC%80%E5%8F%91
 * 
 * @author Birdy
 *
 */
public class JcsegDictionary implements NlpDictionary {

    private ADictionary dictionary;

    public JcsegDictionary(ADictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean contain(String text) {
        return dictionary.match(ILexicon.CJK_WORD, text);
    }

}
