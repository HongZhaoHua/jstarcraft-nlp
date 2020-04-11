package com.jstarcraft.nlp.lucene.ansj;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public class AnsjTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnsjTokenizerFactory.class);

    public AnsjTokenizerFactory(Map<String, String> configuration) {
        super(configuration);
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return AnsjAnalyzer.getTokenizer(null, getOriginalArgs());
    }

}
