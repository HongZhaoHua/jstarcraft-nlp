package com.jstarcraft.nlp.tokenization.ik;

import java.util.Iterator;

import org.wltea.analyzer.core.Lexeme;

import com.jstarcraft.nlp.tokenization.Token;

public class IkToken implements Iterable<IkToken>, Iterator<IkToken>, Token {

    private Iterator<Lexeme> iterator;

    private Lexeme lexeme;
    
    public IkToken(Iterator<Lexeme> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<IkToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public IkToken next() {
        lexeme = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return lexeme.getLexemeText();
    }

    @Override
    public int getBegin() {
        return lexeme.getBeginPosition();
    }

    @Override
    public int getEnd() {
        return lexeme.getEndPosition();
    }

}
