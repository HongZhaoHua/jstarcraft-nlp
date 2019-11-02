package com.jstarcraft.nlp.tokenization;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.jstarcraft.nlp.tokenization.jieba.JiebaIterator;

public class JiebaIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        SegMode mode = SegMode.SEARCH;
        return new JiebaIterator(segmenter, mode);
    }

}
