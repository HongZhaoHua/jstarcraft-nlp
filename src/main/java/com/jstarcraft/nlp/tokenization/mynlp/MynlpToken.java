package com.jstarcraft.nlp.tokenization.mynlp;

import java.util.Iterator;

import com.jstarcraft.nlp.tokenization.Token;
import com.mayabot.nlp.segment.WordTerm;

public class MynlpToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<WordTerm> iterator;

    private WordTerm word;
    
    public MynlpToken(Iterator<WordTerm> iterator) {
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
        word = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return word.word;
    }

    @Override
    public int getBegin() {
        return word.offset;
    }

    @Override
    public int getEnd() {
        return getBegin() + getTerm().length();
    }

}
