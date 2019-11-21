package com.jstarcraft.nlp.dictionary;

/**
 * NLP字典
 * 
 * @author Birdy
 *
 */
public interface NlpDictionary {

    /**
     * 是否包含指定文本
     * 
     * @param text
     * @return
     */
    boolean contain(String text);

}
