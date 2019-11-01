package com.jstarcraft.nlp.tokenization;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;

import com.jstarcraft.nlp.tokenization.lucene.LuceneTokenizer;

public class LuceneTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        CJKAnalyzer analyzer = new CJKAnalyzer();
        return new LuceneTokenizer(analyzer);
    }

}
