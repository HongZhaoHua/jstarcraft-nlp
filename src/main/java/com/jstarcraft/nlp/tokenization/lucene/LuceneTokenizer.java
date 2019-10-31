package com.jstarcraft.nlp.tokenization.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

import com.jstarcraft.nlp.tokenization.Tokenizer;

public class LuceneTokenizer implements Tokenizer<LuceneToken> {

    private Analyzer analyzer;

    public LuceneTokenizer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public Iterable<LuceneToken> tokenize(CharSequence text) {
        try {
            TokenStream stream = analyzer.tokenStream("text", text.toString());
            stream.reset();
            LuceneToken iterable = new LuceneToken(stream);
            return iterable;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
