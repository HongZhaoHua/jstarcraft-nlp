package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.jstarcraft.nlp.lucene.mmseg.MmsegTokenizer;

public class MmsegTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        Dictionary dictionary = Dictionary.getInstance();
        ComplexSeg complex = new ComplexSeg(dictionary);
//        MMSeg mmSeg = new MMSeg(new StringReader(""), complex);
        MmsegTokenizer tokenizer = new MmsegTokenizer(complex);
        return tokenizer;
    }

}
