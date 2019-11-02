package com.jstarcraft.nlp.tokenization;

import org.ansj.splitWord.analysis.BaseAnalysis;

import com.jstarcraft.nlp.tokenization.ansj.AnsjIterator;

public class AnsjIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
       return new AnsjIterator(new BaseAnalysis());
    }

}
