package com.jstarcraft.nlp.lucene.ansj;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnsjTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnsjTokenizerFactory.class);

    private Map<String, String> args;

    public AnsjTokenizerFactory(Map<String, String> args) {
        super(args);
        this.args = args;
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return AnsjAnalyzer.getTokenizer(null, args);
    }

}
