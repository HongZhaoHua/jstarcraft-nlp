package com.jstarcraft.nlp.tokenization;

import java.io.StringReader;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.mmseg.MmsegTokenizer;

public class MmsegTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        Dictionary dictionary = Dictionary.getInstance();
        ComplexSeg complex = new ComplexSeg(dictionary);
        MMSeg mmSeg = new MMSeg(new StringReader(""), complex);
        return new MmsegTokenizer(mmSeg);
    }

}
