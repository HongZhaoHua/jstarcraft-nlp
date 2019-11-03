package com.jstarcraft.nlp.lucene;

import java.text.BreakIterator;
import java.util.Collections;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.tokenization.NlpIterator;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * Lucene分词工厂
 * 
 * @author Birdy
 *
 */
public class LuceneTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuceneTokenizerFactory.class);

    private BreakIterator iterator;

    private NlpIterator<? extends NlpToken> tokenizer;

    public LuceneTokenizerFactory(BreakIterator iterator, NlpIterator<? extends NlpToken> tokenizer) {
        super(Collections.EMPTY_MAP);
        this.iterator = iterator;
        this.tokenizer = tokenizer;
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new LuceneTokenizer(factory, iterator, tokenizer);
    }

}
