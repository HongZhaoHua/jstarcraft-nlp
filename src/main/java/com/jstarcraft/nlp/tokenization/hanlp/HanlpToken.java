package com.jstarcraft.nlp.tokenization.hanlp;

import java.util.Iterator;

import com.hankcs.hanlp.seg.common.Term;
import com.jstarcraft.nlp.tokenization.NlpToken;

public class HanlpToken implements Iterable<HanlpToken>, Iterator<HanlpToken>, NlpToken {

    private Iterator<Term> iterator;

    private Term term;

    public HanlpToken(Iterator<Term> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<HanlpToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public HanlpToken next() {
        term = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return term.word;
    }

    @Override
    public int getBegin() {
        return term.offset;
    }

    @Override
    public int getEnd() {
        return getBegin() + getTerm().length();
    }

}
