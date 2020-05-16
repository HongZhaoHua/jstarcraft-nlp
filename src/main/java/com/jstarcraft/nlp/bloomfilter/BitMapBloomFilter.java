package com.jstarcraft.nlp.bloomfilter;

import com.jstarcraft.core.common.hash.StringHashFunction;
import com.jstarcraft.nlp.bloomfilter.bit.BitMap;

/**
 * 基于BitMap的布隆过滤器
 * 
 * @author Birdy
 *
 */
public abstract class BitMapBloomFilter extends LocalBloomFilter<BitMap> {

	protected BitMapBloomFilter(BitMap bits, StringHashFunction... functions) {
		super(bits, functions);
	}

	@Override
	public boolean get(String data) {
		int capacity = bits.capacity();
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
	public void put(String data) {
		int capacity = bits.capacity();
		for (StringHashFunction function : functions) {
			int hash = function.hash(data);
			int index = Math.abs(hash % capacity);
			bits.set(index);
		}
	}

}
