package com.jstarcraft.nlp.tokenization.word;

import java.util.List;

import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.Word;

import com.jstarcraft.nlp.tokenization.Tokenizer;

public class WordTokenizer implements Tokenizer<WordToken> {

    private Segmentation segmentation;

    public WordTokenizer(Segmentation segmentation) {
        this.segmentation = segmentation;
    }

    @Override
    public Iterable<WordToken> tokenize(CharSequence text) {
        List<Word> iterator = segmentation.seg(text.toString());
        WordToken iterable = new WordToken(iterator.iterator(), text.toString());
        return iterable;
    }

}
