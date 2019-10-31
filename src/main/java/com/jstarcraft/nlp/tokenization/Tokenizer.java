package com.jstarcraft.nlp.tokenization;

/**
 * 分词器
 * 
 * @author Birdy
 *
 */
public interface Tokenizer<T extends Token> {

    /**
     * 分词
     * 
     * @param text
     * @return
     */
    Iterable<T> tokenize(CharSequence text);

}
