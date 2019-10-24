package com.jstarcraft.nlp.tokenization.jcseg;

import java.util.Iterator;

import org.lionsoul.jcseg.tokenizer.core.IWord;

import com.jstarcraft.nlp.tokenization.Token;

public class JcsegToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<IWord> iterator;

    private IWord word;

    public JcsegToken(Iterator<IWord> iterator) {
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
        return word.getValue();
    }

    @Override
    public int getBegin() {
        return word.getPosition();
    }

    @Override
    public int getEnd() {
        return getBegin() + getTerm().length();
    }

}
