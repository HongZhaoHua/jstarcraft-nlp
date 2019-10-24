package com.jstarcraft.nlp.tokenization.thulac;

import java.util.Iterator;

import com.jstarcraft.nlp.tokenization.Token;

public class ThulacToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<String> iterator;

    private String text;
    
    private String word;

    private int offset;

    public ThulacToken(Iterator<String> iterator, String text) {
        this.iterator = iterator;
        this.text = text;
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
        word = iterator.next();
        offset = text.indexOf(word, offset);
        return this;
    }

    @Override
    public String getTerm() {
        return word;
    }

    @Override
    public int getBegin() {
        return offset;
    }

    @Override
    public int getEnd() {
        return getBegin() + getTerm().length();
    }

}
