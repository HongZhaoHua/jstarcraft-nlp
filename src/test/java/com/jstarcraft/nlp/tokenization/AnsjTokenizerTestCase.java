package com.jstarcraft.nlp.tokenization;

import java.util.Collections;

import org.ansj.splitWord.analysis.BaseAnalysis;

import com.jstarcraft.nlp.tokenization.ansj.AnsjTokenizer;

public class AnsjTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
       return new AnsjTokenizer(new BaseAnalysis());
    }

}
