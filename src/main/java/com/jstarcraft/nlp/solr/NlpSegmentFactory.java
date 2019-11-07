package com.jstarcraft.nlp.solr;

import java.text.BreakIterator;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.lucene.NlpSegmenter;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * Lucene分词工厂
 * 
 * @author Birdy
 *
 */
public abstract class NlpSegmentFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(NlpSegmentFactory.class);

    /** 分句迭代器 */
    private BreakIterator iterator;

    /** 分词迭代器 */
    private NlpTokenizer<? extends NlpToken> tokenizer;

    protected abstract BreakIterator getBreakIterator(Map<String, String> configuration);

    protected abstract NlpTokenizer<? extends NlpToken> getNlpIterator(Map<String, String> configuration);

    public NlpSegmentFactory(Map<String, String> configuration) {
        super(configuration);
        this.iterator = getBreakIterator(configuration);
        this.tokenizer = getNlpIterator(configuration);
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new NlpSegmenter(factory, iterator, tokenizer);
    }

}
