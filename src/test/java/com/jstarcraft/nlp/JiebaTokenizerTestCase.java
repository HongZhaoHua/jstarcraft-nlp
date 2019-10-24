package com.jstarcraft.nlp;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.jieba.JiebaTokenizer;

public class JiebaTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        SegMode mode = SegMode.SEARCH;
        return new JiebaTokenizer(segmenter, mode);
    }

}
