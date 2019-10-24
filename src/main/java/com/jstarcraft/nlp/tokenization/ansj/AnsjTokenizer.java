package com.jstarcraft.nlp.tokenization.ansj;

import org.ansj.domain.Result;
import org.ansj.splitWord.Analysis;

import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

public class AnsjTokenizer implements Tokenizer {

    private Analysis analysis;
    
    public AnsjTokenizer(Analysis analysis) {
        this.analysis = analysis;
    }
    
    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        Result result = analysis.parseStr(text.toString());
        AnsjToken iterable = new AnsjToken(result.iterator());
        return iterable;
    }

}
