package com.jstarcraft.nlp.tokenization.mynlp;

import java.util.Iterator;

import com.jstarcraft.nlp.analysis.lexical.tag.NlpTag;
import com.jstarcraft.nlp.analysis.lexical.tag.PekingUniversityTagger;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.mayabot.nlp.segment.Nature;
import com.mayabot.nlp.segment.WordTerm;

/**
 * MYNLP词元
 * 
 * @author Birdy
 *
 */
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

    @Override
    public NlpTag getTag() {
        Nature nature = word.getNature();
        if (nature == Nature.begin) {
            return NlpTag.X;
        }
        if (nature == Nature.end) {
            return NlpTag.X;
        }
        if (nature == Nature.newWord) {
            return NlpTag.X;
        }
        return PekingUniversityTagger.CHINESE_TAGGER.getTag(nature.toString());
    }

    @Override
    public String getNature() {
        Nature nature = word.getNature();
        return nature.toString();
    }

}
