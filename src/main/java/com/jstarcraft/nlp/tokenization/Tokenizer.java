package com.jstarcraft.nlp.tokenization;

/**
 * 分词器
 * 
 * @author Birdy
 *
 */
public interface Tokenizer<T extends Token> {

    Iterable<T> tokenize(CharSequence text);

}
