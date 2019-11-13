package com.jstarcraft.nlp.tokenization;

/**
 * NLP分词器
 * 
 * @author Birdy
 *
 */
public interface NlpTokenizer<T extends NlpToken> {

    /**
     * 分词
     * 
     * @param text
     * @return
     */
    Iterable<T> tokenize(CharSequence text);

}
