package com.jstarcraft.nlp.lucene.mynlp;

import org.apache.lucene.analysis.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mayabot.nlp.segment.LexerReader;
import com.mayabot.nlp.segment.WordTermIterableMode;

@Deprecated
public class MynlpAnalyzer extends Analyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MynlpAnalyzer.class);

    private MynlpTokenizer tokenizer;

    public MynlpAnalyzer(MynlpTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public MynlpAnalyzer(LexerReader reader) {
        this.tokenizer = new MynlpTokenizer(reader);
    }

    public MynlpAnalyzer(LexerReader reader, WordTermIterableMode mode) {
        this.tokenizer = new MynlpTokenizer(reader, mode);
    }

    @Override
    protected TokenStreamComponents createComponents(final String fieldName) {
        return new TokenStreamComponents(tokenizer);
    }

}
