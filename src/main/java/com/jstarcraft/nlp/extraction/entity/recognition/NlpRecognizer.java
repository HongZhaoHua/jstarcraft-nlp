package com.jstarcraft.nlp.extraction.entity.recognition;

import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * NLP识别器
 * 
 * @author Birdy
 *
 */
public interface NlpRecognizer {

    /**
     * 识别
     * 
     * @param token
     * @return
     */
    boolean recognize(NlpToken token);

}
