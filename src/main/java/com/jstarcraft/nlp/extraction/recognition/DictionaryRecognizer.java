package com.jstarcraft.nlp.extraction.recognition;

import com.jstarcraft.nlp.dictionary.NlpDictionary;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * 基于词典识别器
 * 
 * @author Birdy
 *
 */
public class DictionaryRecognizer implements NlpRecognizer {

    private NlpDictionary dictionary;

    public DictionaryRecognizer(NlpDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean recognize(NlpToken token) {
        return dictionary.contain(token.getTerm());
    }

}
