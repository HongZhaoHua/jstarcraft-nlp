package com.jstarcraft.nlp.tokenization.mmseg;

import java.util.Iterator;

import com.chenlb.mmseg4j.Word;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * MMSEG词元
 * 
 * @author Birdy
 *
 */
public class MmsegToken implements Iterable<MmsegToken>, Iterator<MmsegToken>, NlpToken {

    private Iterator<Word> iterator;

    private Word word;

    public MmsegToken(Iterator<Word> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<MmsegToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public MmsegToken next() {
        word = iterator.next();
        return this;
    }

    @Override
    public String getTerm() {
        return word.getString();
    }

    @Override
    public int getBegin() {
        return word.getStartOffset();
    }

    @Override
    public int getEnd() {
        return word.getEndOffset();
    }

}
