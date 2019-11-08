package com.jstarcraft.nlp.lucene;

import java.util.Collections;

import org.ansj.splitWord.analysis.BaseAnalysis;
import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.ansj.AnsjTokenizer;

public class AnsjSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getSegmenter() {
        AnsjTokenizer tokenizer = new AnsjTokenizer(new BaseAnalysis(), Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        return tokenizer;
    }

}
