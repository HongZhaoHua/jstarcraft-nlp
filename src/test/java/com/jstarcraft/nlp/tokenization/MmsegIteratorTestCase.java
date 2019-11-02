package com.jstarcraft.nlp.tokenization;

import java.io.StringReader;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.jstarcraft.nlp.tokenization.mmseg.MmsegIterator;

public class MmsegIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        Dictionary dictionary = Dictionary.getInstance();
        ComplexSeg complex = new ComplexSeg(dictionary);
        MMSeg mmSeg = new MMSeg(new StringReader(""), complex);
        return new MmsegIterator(mmSeg);
    }

}
