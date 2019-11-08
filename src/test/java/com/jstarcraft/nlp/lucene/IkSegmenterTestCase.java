package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.ik.IkTokenizer;

public class IkSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getSegmenter() {
//        new IKSegmenter(null, true)
        IkTokenizer tokenizer = new IkTokenizer(true);
        return tokenizer;
    }

}
