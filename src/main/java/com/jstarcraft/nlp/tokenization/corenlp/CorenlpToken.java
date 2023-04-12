package com.jstarcraft.nlp.tokenization.corenlp;

import java.util.Iterator;

import com.jstarcraft.nlp.analysis.lexical.tag.NlpTag;
import com.jstarcraft.nlp.analysis.lexical.tag.PennTreebankTagger;
import com.jstarcraft.nlp.tokenization.NlpToken;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

/**
 * CoreNLP词元
 * 
 * @author Birdy
 *
 */
public class CorenlpToken implements Iterable<CorenlpToken>, Iterator<CorenlpToken>, NlpToken {

    private Iterator<CoreLabel> iterator;

    private String text;

    private String nature;

    private Integer begin;

    private Integer end;

    public CorenlpToken(Iterator<CoreLabel> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<CorenlpToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public CorenlpToken next() {
        CoreLabel label = iterator.next();
        text = label.get(CoreAnnotations.TextAnnotation.class);
        nature = label.get(CoreAnnotations.PartOfSpeechAnnotation.class);
        begin = label.beginPosition();
        end = label.endPosition();
        return this;
    }

    @Override
    public String getTerm() {
        return text;
    }

    @Override
    public int getBegin() {
        return begin;
    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public NlpTag getTag() {
        return PennTreebankTagger.CHINESE_TAGGER.getTag(nature);
    }

    @Override
    public String getNature() {
        return nature;
    }

}
