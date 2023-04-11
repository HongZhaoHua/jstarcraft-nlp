package com.jstarcraft.nlp.algorithm;

import it.unimi.dsi.fastutil.ints.IntSet;

/**
 * Term Frequency
 * 
 * @author Birdy
 *
 */
public interface TermFrequency {

	IntSet getKeys();

	float getValue(int key);

	int getLength();

}
