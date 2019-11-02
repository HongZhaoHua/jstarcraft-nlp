package com.jstarcraft.nlp.tokenization;

/**
 * 分词器
 * 
 * @author Birdy
 *
 */
public interface NlpIterator<T extends NlpToken> {

    /**
     * 分词
     * 
     * @param text
     * @return
     */
    Iterable<T> tokenize(CharSequence text);

}
