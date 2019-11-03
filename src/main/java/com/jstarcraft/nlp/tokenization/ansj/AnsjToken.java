package com.jstarcraft.nlp.tokenization.ansj;

import java.util.Iterator;

import org.ansj.domain.Term;

import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * Ansj词元
 * 
 * @author Birdy
 *
 */
public class AnsjToken implements Iterable<AnsjToken>, Iterator<AnsjToken>, NlpToken {

    private Iterator<Term> iterator;

    private Term term;

    public AnsjToken(Iterator<Term> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<AnsjToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public AnsjToken next() {
        term = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return term.getName();
    }

    @Override
    public int getBegin() {
        return term.getOffe();
    }

    @Override
    public int getEnd() {
        return getBegin() + getTerm().length();
    }

}
