package com.jstarcraft.nlp.lucene.hanlp;

import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hankcs.hanlp.HanLP;

/**
 * HanLP索引分析器(仅用于索引)
 * 
 * @author Birdy
 *
 */
public class HanlpIndexAnalyzer extends Analyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HanlpIndexAnalyzer.class);

    private String algorithm;

    private Set<String> filter;

    public HanlpIndexAnalyzer(String algorithm, Set<String> filter) {
        this.algorithm = algorithm;
        this.filter = filter;
    }

    public HanlpIndexAnalyzer(String algorithm) {
        super();
        this.algorithm = algorithm;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer from = new HanlpTokenizer(HanLP.newSegment(algorithm).enableIndexMode(true), filter);
        TokenStream to = new LowerCaseFilter(from);
        to = new PorterStemFilter(to);
        return new TokenStreamComponents(from, to);
    }

}
