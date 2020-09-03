package com.jstarcraft.nlp.bloomfilter;

import java.util.Random;

import com.jstarcraft.core.common.hash.StringHashFunction;

public abstract class LocalBloomFilter<T> implements BloomFilter {

	protected T bits;

	protected StringHashFunction[] functions;

	protected static StringHashFunction[] getFunctions(StringHashFamily hashFamily, int hashSize, Random random) {
		StringHashFunction[] functions = new StringHashFunction[hashSize];
		for (int index = 0; index < hashSize; index++) {
			functions[index] = hashFamily.getHashFunction(random);
		}
		return functions;
	}

	protected LocalBloomFilter(T bits, StringHashFunction... functions) {
		this.bits = bits;
		this.functions = functions;
	}

}
