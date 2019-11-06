package com.jstarcraft.nlp.lucene.jieba;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;

public class JiebaTokenizerFactory extends TokenizerFactory {

    private JiebaSegmenter.SegMode segMode;

    public JiebaTokenizerFactory(Map<String, String> args) {
        super(args);
        if (null == args.get("segMode")) {
            segMode = SegMode.SEARCH;
        } else {
            segMode = JiebaSegmenter.SegMode.valueOf(args.get("segMode"));
        }
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new JiebaTokenizer(segMode);
    }

}
