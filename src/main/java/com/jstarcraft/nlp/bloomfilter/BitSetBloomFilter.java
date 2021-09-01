package com.jstarcraft.nlp.bloomfilter;

import java.util.BitSet;
import java.util.Random;

import com.jstarcraft.core.common.hash.StringHashFunction;

/**
 * 基于BitSet的布隆过滤器
 * 
 * @author Birdy
 *
 */
public class BitSetBloomFilter extends LocalBloomFilter<BitSet> {

	private int capacity;

	public BitSetBloomFilter(int bitSize, StringHashFamily hashFamily, int hashSize, Random random) {
		super(new BitSet(bitSize), getFunctions(hashFamily, hashSize, random));
		this.capacity = bitSize;
	}

	@Override
	public boolean getBit(String data) {
		for (StringHashFunction function : functions) {
			int hash = function.hash(data);
			int index = Math.abs(hash % capacity);
			if (!bits.get(index)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void putBit(String data) {
		for (StringHashFunction function : functions) {
			int hash = function.hash(data);
			int index = Math.abs(hash % capacity);
			bits.set(index);
		}
	}

}
