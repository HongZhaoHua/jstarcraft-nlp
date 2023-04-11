package com.jstarcraft.nlp.algorithm;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2FloatAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2FloatMap;

public class BinaryTermFrequencyTestCase extends TermFrequencyTestCase {

    @Override
    protected TermFrequency getTermFrequency(List<Integer> document) {
        return new BinaryTermFrequency(new Int2FloatAVLTreeMap(), document);
    }

    @Override
    protected Int2FloatMap calculateTermFrequency(Int2FloatMap keyValues) {
        for (Int2FloatMap.Entry term : keyValues.int2FloatEntrySet()) {
            term.setValue(1F);
        }
        return keyValues;
    }

}
