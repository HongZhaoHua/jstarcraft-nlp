package com.jstarcraft.nlp.tokenization.hanlp;

import java.util.Iterator;

import com.hankcs.hanlp.seg.common.Term;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * HanLP词元
 * 
 * @author Birdy
 *
 */
public class HanLpToken implements Iterable<HanLpToken>, Iterator<HanLpToken>, NlpToken {

    private Iterator<Term> iterator;

    private Term term;

    public HanLpToken(Iterator<Term> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<HanLpToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public HanLpToken next() {
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
