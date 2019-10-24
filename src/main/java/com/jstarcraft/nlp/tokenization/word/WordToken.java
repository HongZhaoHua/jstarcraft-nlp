package com.jstarcraft.nlp.tokenization.word;

import java.util.Iterator;

import org.apdplat.word.segmentation.Word;

import com.jstarcraft.nlp.tokenization.Token;

public class WordToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<Word> iterator;
    
    private String text;

    private Word word;

    private int offset;

    public WordToken(Iterator<Word> iterator, String text) {
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
        offset = text.indexOf(word.getText(), offset);
        return this;
    }

    @Override
    public String getTerm() {
        return word.getText();
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
