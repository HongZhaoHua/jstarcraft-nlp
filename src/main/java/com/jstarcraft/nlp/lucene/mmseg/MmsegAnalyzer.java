package com.jstarcraft.nlp.lucene.mmseg;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.Seg;

/**
 * 默认使用 max-word
 *
 * @see {@link SimpleAnalyzer}, {@link ComplexAnalyzer}, {@link MaxWordAnalyzer}
 *
 * @author chenlb
 */
public class MmsegAnalyzer extends Analyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MmsegAnalyzer.class);

    protected Dictionary dic;

    /**
     * @see Dictionary#getInstance()
     */
    public MmsegAnalyzer() {
    }

    /**
     * @param path 词库路径
     * @see Dictionary#getInstance(String)
     */
    public MmsegAnalyzer(String path) {
        dic = Dictionary.getInstance(path);
    }

    /**
     * @param path 词库目录
     * @see Dictionary#getInstance(File)
     */
    public MmsegAnalyzer(File path) {
        dic = Dictionary.getInstance(path);
    }

    public MmsegAnalyzer(Dictionary dic) {
        super();
        this.dic = dic;
    }

    protected Seg newSeg() {
        return new MaxWordSeg(dic);
    }

    public Dictionary getDict() {
        return dic;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        return new TokenStreamComponents(new MmsegTokenizer(newSeg()));
    }

}
