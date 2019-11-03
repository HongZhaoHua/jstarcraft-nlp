package com.jstarcraft.nlp.lucene.corenlp;

import java.util.Map;
import java.util.Properties;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CoreNlpTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoreNlpTokenizerFactory.class);

    private AnnotationPipeline pipeline;

    public CoreNlpTokenizerFactory(Map<String, String> args) {
        super(args);
        Properties p = new Properties();
        for (Map.Entry<String, String> ent : args.entrySet())
            p.setProperty(ent.getKey(), ent.getValue());
        pipeline = new StanfordCoreNLP(p);
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new CoreNlpTokenizer(factory, pipeline);
    }

}
