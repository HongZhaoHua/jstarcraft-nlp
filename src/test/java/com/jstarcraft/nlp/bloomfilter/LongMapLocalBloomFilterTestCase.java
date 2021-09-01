package com.jstarcraft.nlp.bloomfilter;

import com.jstarcraft.core.common.hash.HashUtility;
import com.jstarcraft.nlp.bloomfilter.local.LongMapLocalBloomFilter;

public class LongMapLocalBloomFilterTestCase extends LocalBloomFilterTestCase {

    @Override
    protected BloomFilter getBloomFilter(int elments, float probability) {
        random.setSeed(0L);
        int bits = BloomFilter.optimalBits(elments, probability);
        int hashs = BloomFilter.optimalHashs(bits, elments);
        StringHashFamily hashFamily = (random) -> {
            int seed = random.nextInt();
            return (data) -> {
                return HashUtility.murmur2StringHash32(seed, data);
            };
        };
        BloomFilter bloomFilter = new LongMapLocalBloomFilter(bits, hashFamily, hashs, random);
        return bloomFilter;
    }

}