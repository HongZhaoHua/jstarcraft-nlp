package com.jstarcraft.nlp.tokenization;

/**
 * 分词器
 * 
 * @author Birdy
 *
 */
public interface Tokenizer {

    Iterable<Token> tokenize(CharSequence text);

}
