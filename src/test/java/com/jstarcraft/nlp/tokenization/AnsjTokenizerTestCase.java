package com.jstarcraft.nlp.tokenization;

import org.ansj.splitWord.analysis.BaseAnalysis;

import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.ansj.AnsjTokenizer;

public class AnsjTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
       return new AnsjTokenizer(new BaseAnalysis());
    }

}
