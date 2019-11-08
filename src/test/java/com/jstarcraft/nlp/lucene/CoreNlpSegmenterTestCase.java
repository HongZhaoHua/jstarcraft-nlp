package com.jstarcraft.nlp.lucene;

import java.util.Properties;

import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.corenlp.CoreNlpTokenizer;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CoreNlpSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getSegmenter() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/StanfordCoreNLP-chinese.properties"));
            StanfordCoreNLP annotator = new StanfordCoreNLP(properties);
            CoreNlpTokenizer tokenizer = new CoreNlpTokenizer(annotator);
            return tokenizer;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
