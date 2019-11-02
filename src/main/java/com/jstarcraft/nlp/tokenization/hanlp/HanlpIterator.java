package com.jstarcraft.nlp.tokenization.hanlp;

import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.jstarcraft.nlp.tokenization.NlpIterator;

public class HanlpIterator implements NlpIterator<HanlpToken> {

    private Segment segment;
    
    public HanlpIterator(Segment segment) {
        this.segment = segment;
    }
    
    @Override
    public Iterable<HanlpToken> tokenize(CharSequence text) {
        Iterable<Term> iterator = segment.seg(text.toString());
        HanlpToken iterable = new  HanlpToken(iterator.iterator());
        return iterable;
    }

}
