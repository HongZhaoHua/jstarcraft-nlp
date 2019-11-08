package com.jstarcraft.nlp.tokenization.hanlp;

import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;

/**
 * HanLP分词器
 * 
 * @author Birdy
 *
 */
public class HanLpTokenizer implements NlpTokenizer<HanLpToken> {

    private Segment segment;

    public HanLpTokenizer(Segment segment) {
        this.segment = segment;
    }

    @Override
    public Iterable<HanLpToken> tokenize(CharSequence text) {
        Iterable<Term> iterator = segment.seg(text.toString());
        HanLpToken iterable = new HanLpToken(iterator.iterator());
        return iterable;
    }

}
