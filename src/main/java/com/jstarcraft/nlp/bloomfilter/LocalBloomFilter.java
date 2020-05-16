package com.jstarcraft.nlp.bloomfilter;

import java.util.Random;

import com.jstarcraft.core.common.hash.StringHashFunction;
import com.jstarcraft.nlp.bloomfilter.bit.BitMap;

public abstract class LocalBloomFilter implements BloomFilter {

    protected BitMap bits;

    protected StringHashFunction[] functions;

    protected static StringHashFunction[] getFunctions(StringHashFamily hashFamily, int hashSize, Random random) {
        StringHashFunction[] functions = new StringHashFunction[hashSize];
        for (int index = 0; index < hashSize; index++) {
            functions[index] = hashFamily.getHashFunction(random);
        }
        return functions;
    }

    protected LocalBloomFilter(BitMap bits, StringHashFunction... functions) {
        this.bits = bits;
        this.functions = functions;
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
