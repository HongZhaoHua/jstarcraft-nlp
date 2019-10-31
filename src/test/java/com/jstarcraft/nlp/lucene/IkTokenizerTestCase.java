package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.ik.IkTokenizer;

public class IkTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
//        new IKSegmenter(null, true)
        IkTokenizer tokenizer = new IkTokenizer(true);
        return tokenizer;
    }

}
