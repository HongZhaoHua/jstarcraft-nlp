package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;

import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.jstarcraft.nlp.lucene.jieba.JiebaTokenizer;

public class JiebaSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getSegmenter() {
        JiebaTokenizer tokenizer = new JiebaTokenizer(SegMode.SEARCH);
        return tokenizer;
    }

}
