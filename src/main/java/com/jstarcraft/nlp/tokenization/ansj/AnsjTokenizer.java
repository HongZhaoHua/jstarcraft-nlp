package com.jstarcraft.nlp.tokenization.ansj;

import java.util.Collection;

import org.ansj.domain.Result;
import org.ansj.recognition.Recognition;
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

    private Recognition[] recognitions;

    public AnsjTokenizer(Analysis analysis, Collection<Recognition> recognitions) {
        this(analysis, recognitions.toArray(new Recognition[recognitions.size()]));
    }

    public AnsjTokenizer(Analysis analysis, Recognition... recognitions) {
        this.analysis = analysis;
        this.recognitions = recognitions;
    }

    @Override
    public Iterable<AnsjToken> tokenize(CharSequence text) {
        Result result = analysis.parseStr(text.toString());
        for (Recognition recognition : recognitions) {
            recognition.recognition(result);
        }
        AnsjToken iterable = new AnsjToken(result.iterator());
        return iterable;
    }

}
