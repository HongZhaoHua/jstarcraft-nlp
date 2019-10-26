package com.jstarcraft.nlp.tokenization.word;

import java.util.Iterator;

import org.apdplat.word.segmentation.Word;

import com.jstarcraft.nlp.tokenization.Token;

public class WordToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<Word> iterator;

    private String text;

    private Word word;

    private int begin;

    private int end;

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
        begin = text.indexOf(word.getText(), end);
        end = begin + word.getText().length();
        return this;
    }

    @Override
    public String getTerm() {
        return word.getText();
    }

    @Override
    public int getBegin() {
        return begin;
    }

    @Override
    public int getEnd() {
        return end;
    }

}
