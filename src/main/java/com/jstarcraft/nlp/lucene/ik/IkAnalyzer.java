package com.jstarcraft.nlp.lucene.ik;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IK分词器，Lucene Analyzer接口实现
 */
@SuppressWarnings("unused")
public final class IkAnalyzer extends Analyzer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(IkAnalyzer.class);

    private boolean useSmart;

    private boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    /**
     * IK分词器Lucene Analyzer接口实现类
     * 
     * 默认细粒度切分算法
     */
    public IkAnalyzer() {
        this(false);
    }

    /**
     * IK分词器Lucene Analyzer接口实现类
     * 
     * @param useSmart 当为true时，分词器进行智能切分
     */
    public IkAnalyzer(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    /**
     * 重载Analyzer接口，构造分词组件
     */
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer _IKTokenizer = new IkTokenizer(this.useSmart());
        return new TokenStreamComponents(_IKTokenizer);
    }

}
