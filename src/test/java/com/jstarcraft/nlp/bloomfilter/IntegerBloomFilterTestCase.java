package com.jstarcraft.nlp.bloomfilter;

import com.jstarcraft.core.common.hash.HashUtility;
import com.jstarcraft.nlp.bloomfilter.BloomFilter;
import com.jstarcraft.nlp.bloomfilter.IntegerBloomFilter;
import com.jstarcraft.nlp.bloomfilter.LocalBloomFilter;
import com.jstarcraft.nlp.bloomfilter.StringHashFamily;

public class IntegerBloomFilterTestCase extends LocalBloomFilterTestCase {

    @Override
    protected BloomFilter getBloomFilter(int elments, float probability) {
        random.setSeed(0L);
        int bits = LocalBloomFilter.optimalBits(elments, probability);
        int hashs = LocalBloomFilter.optimalHashs(bits, elments);
        StringHashFamily hashFamily = (random) -> {
            int seed = random.nextInt();
            return (data) -> {
                return HashUtility.murmur2StringHash32(seed, data);
            };
        };
        BloomFilter bloomFilter = new IntegerBloomFilter(bits, hashFamily, hashs, random);
        return bloomFilter;
    }

}