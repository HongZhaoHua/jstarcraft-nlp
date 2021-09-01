package com.jstarcraft.nlp.bloomfilter.local;

import java.util.Random;

import com.jstarcraft.nlp.bloomfilter.StringHashFamily;
import com.jstarcraft.nlp.bloomfilter.bit.LongMap;

/**
 * 基于LongMap的布隆过滤器
 * 
 * @author Birdy
 *
 */
public class LongMapLocalBloomFilter extends BitMapLocalBloomFilter<long[]> {

	public LongMapLocalBloomFilter(int bitSize, StringHashFamily hashFamily, int hashSize, Random random) {
		super(bitSize, new LongMap(bitSize), getFunctions(hashFamily, hashSize, random));
	}

}
