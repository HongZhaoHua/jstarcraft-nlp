package com.jstarcraft.nlp.tokenization.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.huaban.analysis.jieba.SegToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;

/**
 * jieba分词器
 * 
 * @author Birdy
 *
 */
public class JiebaTokenizer implements NlpTokenizer<JiebaToken> {

    private JiebaSegmenter segmenter;

    private SegMode mode;

    public JiebaTokenizer(JiebaSegmenter segmenter, SegMode mode) {
        this.segmenter = segmenter;
        this.mode = mode;
    }

    @Override
    public Iterable<JiebaToken> tokenize(CharSequence text) {
        Iterable<SegToken> iterator = segmenter.process(text.toString(), mode);
        JiebaToken iterable = new JiebaToken(iterator.iterator());
        return iterable;
    }

}
