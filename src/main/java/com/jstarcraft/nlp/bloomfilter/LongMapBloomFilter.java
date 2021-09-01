package com.jstarcraft.nlp.bloomfilter;

import java.util.Random;

import com.jstarcraft.nlp.bloomfilter.bit.LongMap;

/**
 * 基于LongMap的布隆过滤器
 * 
 * @author Birdy
 *
 */
public class LongMapBloomFilter extends BitMapBloomFilter<long[]> {

	public LongMapBloomFilter(int bitSize, StringHashFamily hashFamily, int hashSize, Random random) {
		super(bitSize, new LongMap(bitSize), getFunctions(hashFamily, hashSize, random));
	}

}
