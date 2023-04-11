package com.jstarcraft.nlp.algorithm;

/**
 * N元模型
 * 
 * @author Birdy
 *
 * @param <N>
 */
public interface Ngram<N> extends Iterable<N> {

	int getSize();

}
