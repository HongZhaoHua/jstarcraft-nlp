package com.jstarcraft.nlp.lucene.corenlp;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.BaseTokenStreamTestCase;
import org.junit.jupiter.api.Test;

import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.PropertiesUtils;

public class CorenlpTokenizerTestCase extends BaseTokenStreamTestCase {

    /** Test splitting only */
    @Test
    public void testBasic() throws IOException {
        AnnotationPipeline pipeline = new StanfordCoreNLP(PropertiesUtils.asProperties(//
                "annotators", "tokenize,ssplit", //
                "tokenize.language", "en", //
                "tokenize.options", "americanize=true,asciiQuotes=true,ptb3Dashes=true,ptb3Ellipsis=true,untokenizable=noneKeep" //
        ));

        CorenlpTokenizer tokenizer = new CorenlpTokenizer(pipeline);
        String str = "Mary had a little lamb. And everywhere that Mary went, the lamb was sure to go.";
        tokenizer.setReader(new StringReader(str));
        assertTokenStreamContents(tokenizer, //
                new String[] { "Mary", "had", "a", "little", "lamb", ".", //
                        "And", "everywhere", "that", "Mary", "went", ",", //
                        "the", "lamb", "was", "sure", "to", "go", "." },
                // Start offsets:
                new int[] { 0, 5, 9, 11, 18, 22, //
                        24, 28, 39, 44, 49, 53, //
                        55, 59, 64, 68, 73, 76, 78 },
                // End offsets:
                new int[] { 4, 8, 10, 17, 22, 23, //
                        27, 38, 43, 48, 53, 54, //
                        58, 63, 67, 72, 75, 78, 79 },
                // Increments:
                new int[] { 1, 1, 1, 1, 1, 1, //
                        1 + CorenlpTokenizer.SENTENCE_GAP, 1, 1, 1, 1, 1, //
                        1, 1, 1, 1, 1, 1, 1, 1 } //
        );
    }

    /** Test with part of speech and lemmatization */
    @Test
    public void testWithLemma() throws IOException {
        AnnotationPipeline pipeline = new StanfordCoreNLP(PropertiesUtils.asProperties(//
                "annotators", "tokenize,ssplit,pos,lemma", //
                "parse.model", "edu/stanford/nlp/models/srparser/englishSR.ser.gz", //
                "tokenize.language", "en", //
                "tokenize.options", "americanize=true,asciiQuotes=true,ptb3Dashes=true,ptb3Ellipsis=true,untokenizable=noneKeep" //
        ));

        CorenlpTokenizer tokenizer = new CorenlpTokenizer(pipeline);
        String str = "Mary had a little lamb. And everywhere that Mary went, the lamb was sure to go.";
        tokenizer.setReader(new StringReader(str));
        assertTokenStreamContents(tokenizer, //
                new String[] { "Mary", "have", "a", "little", "lamb", ".", //
                        "and", "everywhere", "that", "Mary", "go", ",", //
                        "the", "lamb", "be", "sure", "to", "go", "." },
                // Start offsets:
                new int[] { 0, 5, 9, 11, 18, 22, //
                        24, 28, 39, 44, 49, 53, //
                        55, 59, 64, 68, 73, 76, 78 },
                // End offsets:
                new int[] { 4, 8, 10, 17, 22, 23, //
                        27, 38, 43, 48, 53, 54, //
                        58, 63, 67, 72, 75, 78, 79 },
                // Types
                new String[] { "NNP", "VBD", "DT", "JJ", "NN", ".", //
                        "CC", "RB", "IN", "NNP", "VBD", ",", //
                        "DT", "NN", "VBD", "JJ", "TO", "VB", "." },
                // Increments:
                new int[] { 1, 1, 1, 1, 1, 1, //
                        1 + CorenlpTokenizer.SENTENCE_GAP, 1, 1, 1, 1, 1, //
                        1, 1, 1, 1, 1, 1, 1, 1 } //
        );
    }

    /** Test with NER */
    @Test
    public void testWithNER() throws IOException {
        AnnotationPipeline pipeline = new StanfordCoreNLP(PropertiesUtils.asProperties(//
                "annotators", "tokenize,ssplit,pos,lemma,ner", //
                "parse.model", "edu/stanford/nlp/models/srparser/englishSR.ser.gz", //
                "tokenize.language", "en", //
                "tokenize.options", "americanize=true,asciiQuotes=true,ptb3Dashes=true,ptb3Ellipsis=true,untokenizable=noneKeep" //
        ));

        CorenlpTokenizer tokenizer = new CorenlpTokenizer(pipeline);
        String str = "Mary had a little lamb. And everywhere that Mary went, the lamb was sure to go.";
        tokenizer.setReader(new StringReader(str));
        assertTokenStreamContents(tokenizer, //
                new String[] { "Mary", "have", "a", "little", "lamb", ".", //
                        "and", "everywhere", "that", "Mary", "go", ",", //
                        "the", "lamb", "be", "sure", "to", "go", "." },
                // Start offsets:
                new int[] { 0, 5, 9, 11, 18, 22, //
                        24, 28, 39, 44, 49, 53, //
                        55, 59, 64, 68, 73, 76, 78 },
                // End offsets:
                new int[] { 4, 8, 10, 17, 22, 23, //
                        27, 38, 43, 48, 53, 54, //
                        58, 63, 67, 72, 75, 78, 79 },
                // Types
                new String[] { "PERSON", "VBD", "DT", "JJ", "NN", ".", //
                        "CC", "RB", "IN", "PERSON", "VBD", ",", //
                        "DT", "NN", "VBD", "JJ", "TO", "VB", "." },
                // Increments:
                new int[] { 1, 1, 1, 1, 1, 1, //
                        1 + CorenlpTokenizer.SENTENCE_GAP, 1, 1, 1, 1, 1, //
                        1, 1, 1, 1, 1, 1, 1, 1 } //
        );
    }

}
