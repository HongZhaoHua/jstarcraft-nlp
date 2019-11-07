package com.jstarcraft.nlp.tokenization.ansj;

import org.ansj.domain.Result;
import org.ansj.splitWord.Analysis;

import com.jstarcraft.nlp.tokenization.NlpTokenizer;

/**
 * Ansj分词器
 * 
 * @author Birdy
 *
 */
public class AnsjTokenizer implements NlpTokenizer<AnsjToken> {

    private Analysis analysis;

    public AnsjTokenizer(Analysis analysis) {
        this.analysis = analysis;
    }

    @Override
    public Iterable<AnsjToken> tokenize(CharSequence text) {
        Result result = analysis.parseStr(text.toString());
        AnsjToken iterable = new AnsjToken(result.iterator());
        return iterable;
    }

}
