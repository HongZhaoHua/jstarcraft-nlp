package com.jstarcraft.nlp.tokenization.jieba;

import java.util.Iterator;

import com.huaban.analysis.jieba.SegToken;
import com.jstarcraft.nlp.tokenization.Token;

public class JiebaToken implements Iterable<JiebaToken>, Iterator<JiebaToken>, Token {

    private Iterator<SegToken> iterator;

    private SegToken token;
    
    public JiebaToken(Iterator<SegToken> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<JiebaToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public JiebaToken next() {
        token = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return token.word;
    }

    @Override
    public int getBegin() {
        return token.startOffset;
    }

    @Override
    public int getEnd() {
        return token.endOffset;
    }

}
