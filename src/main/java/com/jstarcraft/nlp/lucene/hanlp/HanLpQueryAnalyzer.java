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
 * HanLP查询分析器(仅用于查询)
 * 
 * @author Birdy
 *
 */
public class HanLpQueryAnalyzer extends Analyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HanLpQueryAnalyzer.class);

    private String algorithm;

    private Set<String> filter;

    public HanLpQueryAnalyzer(String algorithm, Set<String> filter) {
        this.algorithm = algorithm;
        this.filter = filter;
    }

    public HanLpQueryAnalyzer(String algorithm) {
        super();
        this.algorithm = algorithm;
    }

    /**
     * 重载Analyzer接口,构造分词组件
     */
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer from = new HanLpTokenizer(HanLP.newSegment(algorithm).enableOffset(true), filter);
        TokenStream to = new LowerCaseFilter(from);
        to = new PorterStemFilter(to);
        return new TokenStreamComponents(from, to);
    }

}
