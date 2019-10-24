package com.jstarcraft.nlp;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;

import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.lucene.LuceneTokenizer;

public class LuceneTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        CJKAnalyzer analyzer = new CJKAnalyzer();
        return new LuceneTokenizer(analyzer);
    }

}
