package com.jstarcraft.nlp.tokenization;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.jstarcraft.nlp.tokenization.jieba.JiebaTokenizer;

public class JiebaTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        SegMode mode = SegMode.SEARCH;
        return new JiebaTokenizer(segmenter, mode);
    }

}
