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
        int bits = LocalBloomFilter.optimalBits(elments, probability);
        int hashs = LocalBloomFilter.optimalHashs(bits, elments);
        Assert.assertEquals(997, LocalBloomFilter.optimalElements(bits, hashs));
        Assert.assertEquals(9.998266E-4F, LocalBloomFilter.optimalProbability(bits, elments, hashs), 0F);
    }

}