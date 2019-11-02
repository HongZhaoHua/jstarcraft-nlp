package com.jstarcraft.nlp.tokenization;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;

import com.jstarcraft.nlp.tokenization.lucene.LuceneIterator;

public class LuceneIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        CJKAnalyzer analyzer = new CJKAnalyzer();
        return new LuceneIterator(analyzer);
    }

}
