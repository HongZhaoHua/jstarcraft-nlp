package com.jstarcraft.nlp.lucene.corenlp;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@Deprecated
public class CorenlpTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorenlpTokenizerFactory.class);

    private AnnotationPipeline pipeline;

    public CorenlpTokenizerFactory(Map<String, String> configuration) {
        super(configuration);
        Properties properties = new Properties();
        for (Entry<String, String> term : configuration.entrySet()) {
            properties.setProperty(term.getKey(), term.getValue());
        }
        pipeline = new StanfordCoreNLP(properties);
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new CorenlpTokenizer(factory, pipeline);
    }

}
