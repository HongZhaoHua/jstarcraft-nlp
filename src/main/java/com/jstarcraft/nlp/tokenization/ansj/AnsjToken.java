package com.jstarcraft.nlp.tokenization.ansj;

import java.util.Iterator;

import org.ansj.domain.Term;

import com.jstarcraft.nlp.tokenization.Token;

public class AnsjToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<Term> iterator;

    private Term term;
    
    public AnsjToken(Iterator<Term> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<Token> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Token next() {
        term = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return term.getName().toLowerCase();
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
