package com.jstarcraft.nlp.tokenization;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;

import com.jstarcraft.nlp.tokenization.lucene.LuceneTokenizer;

public class LuceneTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer<? extends Token> getTokenizer() {
        CJKAnalyzer analyzer = new CJKAnalyzer();
        return new LuceneTokenizer(analyzer);
    }

}
