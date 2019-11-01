package com.jstarcraft.nlp.tokenization.mynlp;

import java.util.Iterator;

import com.jstarcraft.nlp.tokenization.NlpToken;
import com.mayabot.nlp.segment.WordTerm;

public class MynlpToken implements Iterable<MynlpToken>, Iterator<MynlpToken>, NlpToken {

    private Iterator<WordTerm> iterator;

    private WordTerm word;
    
    public MynlpToken(Iterator<WordTerm> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<MynlpToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public MynlpToken next() {
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
