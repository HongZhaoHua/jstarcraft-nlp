package com.jstarcraft.nlp.tokenization;

import java.util.Properties;

import com.jstarcraft.nlp.tokenization.corenlp.CoreNlpIterator;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CoreNlpIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/StanfordCoreNLP-chinese.properties"));
            StanfordCoreNLP annotator = new StanfordCoreNLP(properties);
            return new CoreNlpIterator(annotator);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
