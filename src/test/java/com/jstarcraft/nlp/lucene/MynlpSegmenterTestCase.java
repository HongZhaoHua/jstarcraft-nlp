package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.mynlp.MynlpTokenizer;
import com.mayabot.nlp.segment.Lexers;

public class MynlpSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getSegmenter() {
        MynlpTokenizer tokenizer = new MynlpTokenizer(Lexers.core().filterReader(true, true));
        return tokenizer;
    }

}
