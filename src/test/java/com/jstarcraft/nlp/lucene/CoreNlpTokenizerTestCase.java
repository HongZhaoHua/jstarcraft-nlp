package com.jstarcraft.nlp.lucene;

import java.util.Properties;

import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.corenlp.CoreNLPTokenizer;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CoreNlpTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/StanfordCoreNLP-chinese.properties"));
            StanfordCoreNLP annotator = new StanfordCoreNLP(properties);
            CoreNLPTokenizer tokenizer = new CoreNLPTokenizer(annotator);
            return tokenizer;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
