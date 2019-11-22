package com.jstarcraft.nlp.tokenization.word;

import java.util.Iterator;

import org.apdplat.word.segmentation.PartOfSpeech;
import org.apdplat.word.segmentation.Word;

import com.hankcs.hanlp.corpus.tag.Nature;
import com.jstarcraft.nlp.analysis.lexical.tag.NlpTag;
import com.jstarcraft.nlp.analysis.lexical.tag.PekingUniversityTagger;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * word词元
 * 
 * @author Birdy
 *
 */
public class WordToken implements Iterable<WordToken>, Iterator<WordToken>, NlpToken {

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
    public Iterator<WordToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public WordToken next() {
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

    @Override
    public NlpTag getTag() {
        PartOfSpeech nature = word.getPartOfSpeech();
        // 未知
        if (nature == PartOfSpeech.I) {
            return NlpTag.X;
        }
        // 英语
        if (nature.getPos().equalsIgnoreCase("w")) {
            return NlpTag.X;
        }
        return PekingUniversityTagger.CHINESE_TAGGER.getTag(nature.getPos());
    }

    @Override
    public String getNature() {
        PartOfSpeech nature = word.getPartOfSpeech();
        return nature.getPos();
    }

}
