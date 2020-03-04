package com.jstarcraft.nlp.extraction.recognition;

import java.util.List;

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
     * @param text
     * @return
     */
    List<String> recognize(String text);

}
