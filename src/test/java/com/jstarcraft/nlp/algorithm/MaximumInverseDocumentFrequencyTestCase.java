package com.jstarcraft.nlp.algorithm;

import java.util.Collection;

import org.apache.commons.math3.util.FastMath;

import it.unimi.dsi.fastutil.ints.Int2FloatAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2FloatMap;

public class MaximumInverseDocumentFrequencyTestCase extends InverseDocumentFrequencyTestCase {

    @Override
    protected InverseDocumentFrequency getInverseDocumentFrequency(Collection<TermFrequency> documents) {
        return new MaximumInverseDocumentFrequency(new Int2FloatAVLTreeMap(), documents);
    }

    @Override
    protected Int2FloatMap calculateInverseDocumentFrequency(Int2FloatMap keyValues) {
        for (Int2FloatMap.Entry term : keyValues.int2FloatEntrySet()) {
            term.setValue((float) FastMath.log(2F / (1F + term.getFloatValue())));
        }
        return keyValues;
    }

}
