package com.jstarcraft.nlp.tokenization.thulac;

import java.util.Iterator;

import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * THULAC词元
 * 
 * @author Birdy
 *
 */
public class ThulacToken implements Iterable<ThulacToken>, Iterator<ThulacToken>, NlpToken {

    private Iterator<String> iterator;

    private String text;

    private String word;

    private int begin;

    private int end;

    public ThulacToken(Iterator<String> iterator, String text) {
        this.iterator = iterator;
        this.text = text;
    }

    @Override
    public Iterator<ThulacToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public ThulacToken next() {
        word = iterator.next();
        begin = text.indexOf(word, end);
        end = begin + word.length();
        return this;
    }

    @Override
    public String getTerm() {
        return word;
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
