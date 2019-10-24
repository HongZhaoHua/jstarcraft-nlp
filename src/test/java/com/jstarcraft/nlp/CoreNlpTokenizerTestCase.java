package com.jstarcraft.nlp;

import java.util.Properties;

import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.corenlp.CoreNlpTokenizer;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CoreNlpTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/StanfordCoreNLP-chinese.properties"));
            StanfordCoreNLP annotator = new StanfordCoreNLP(properties);
            return new CoreNlpTokenizer(annotator);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
