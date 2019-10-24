package com.jstarcraft.nlp.tokenization.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.huaban.analysis.jieba.SegToken;
import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

public class JiebaTokenizer implements Tokenizer {

    private JiebaSegmenter segmenter;

    private SegMode mode;

    public JiebaTokenizer(JiebaSegmenter segmenter, SegMode mode) {
        this.segmenter = segmenter;
        this.mode = mode;
    }

    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        Iterable<SegToken> iterator = segmenter.process(text.toString(), mode);
        JiebaToken iterable = new JiebaToken(iterator.iterator());
        return iterable;
    }

}
