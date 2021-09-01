package com.jstarcraft.nlp.bloomfilter;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBucket;
import org.redisson.client.codec.ByteArrayCodec;

/**
 * 基于Redis的布隆过滤器
 * 
 * @author Birdy
 *
 */
public class GlobalBloomFilter implements BloomFilter {

    private RBloomFilter<String> bloomFilter;

    private RBucket<byte[]> bytes;

    public GlobalBloomFilter(Redisson redisson, String name) {
        this.bloomFilter = redisson.getBloomFilter(name);
        this.bytes = redisson.getBucket(name, ByteArrayCodec.INSTANCE);
    }

    public GlobalBloomFilter(Redisson redisson, String name, int elments, float probability) {
        this.bloomFilter = redisson.getBloomFilter(name);
        if (!this.bloomFilter.tryInit(elments, probability)) {
            throw new RuntimeException("布隆过滤器冲突");
        }
        this.bytes = redisson.getBucket(name, ByteArrayCodec.INSTANCE);
    }

    @Override
    public boolean getBit(String data) {
        return bloomFilter.contains(data);
    }

    @Override
    public void putBit(String data) {
        bloomFilter.add(data);
    }

    public int bitSize() {
        return (int) bloomFilter.getSize();
    }
    
    public int hashSize() {
        return (int) bloomFilter.getHashIterations();
    }

    public byte[] getBytes() {
        return bytes.get();
    }

}
