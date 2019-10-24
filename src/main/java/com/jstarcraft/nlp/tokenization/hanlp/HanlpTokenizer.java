package com.jstarcraft.nlp.tokenization.hanlp;

import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

public class HanlpTokenizer implements Tokenizer {

    private Segment segment;
    
    public HanlpTokenizer(Segment segment) {
        this.segment = segment;
    }
    
    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        Iterable<Term> iterator = segment.seg(text.toString());
        HanlpToken iterable = new  HanlpToken(iterator.iterator());
        return iterable;
    }

}
