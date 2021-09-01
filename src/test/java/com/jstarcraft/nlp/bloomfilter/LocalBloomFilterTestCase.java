package com.jstarcraft.nlp.bloomfilter;

import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public abstract class LocalBloomFilterTestCase extends BloomFilterTestCase {

    protected static Random random = new Random();

    @Test
    public void testOptimal() {
        int elments = 1000;
        float probability = 0.001F;
        int bits = BloomFilter.optimalBits(elments, probability);
        int hashs = BloomFilter.optimalHashs(bits, elments);
        System.out.println(bits);
        System.out.println(hashs);
        Assert.assertEquals(997, BloomFilter.optimalElements(bits, hashs));
        Assert.assertEquals(0.0010003077F, BloomFilter.optimalProbability(bits, elments, hashs), 0F);
    }

}