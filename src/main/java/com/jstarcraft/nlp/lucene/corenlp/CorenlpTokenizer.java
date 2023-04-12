package com.jstarcraft.nlp.lucene.corenlp;

import java.io.IOException;
import java.util.Iterator;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.util.CoreMap;

/**
 * Stanford CoreNLP分词器
 * 
 * @author Birdy
 *
 */
public final class CorenlpTokenizer extends Tokenizer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorenlpTokenizer.class);

    final static int SENTENCE_GAP = 10;

    /** 词元 **/
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    /** 位移 **/
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);
    /** 距离 **/
    private final PositionIncrementAttribute positionAttribute = addAttribute(PositionIncrementAttribute.class);
    /** 词性 **/
    private final TypeAttribute typeAttribute = addAttribute(TypeAttribute.class);

    private AnnotationPipeline pipeline;

    private Iterator<CoreMap> sentences = null;

    private Iterator<CoreLabel> tokens = null;

    private int skippedTokens;

    public CorenlpTokenizer(AnnotationPipeline pipeline) {
        this(DEFAULT_TOKEN_ATTRIBUTE_FACTORY, pipeline);
    }

    public CorenlpTokenizer(AttributeFactory factory, AnnotationPipeline pipeline) {
        super(factory);
        this.pipeline = pipeline;
    }

    @Override
    public boolean incrementToken() {
        clearAttributes();
        while (tokens == null || !tokens.hasNext())
            if (!getNextSentence())
                return false;
        CoreLabel token = tokens.next();
        // Use the lemmatized word:
        String word = token.get(LemmaAnnotation.class);
        if (word == null) { // Fallback when no lemmatization happens.
            word = token.get(TextAnnotation.class);
        }
        termAttribute.setLength(0);
        termAttribute.append(word);
        // NER or part of speech annotation
        String pos = token.get(NamedEntityTagAnnotation.class);
        pos = (pos == null || "O".equals(pos)) ? token.get(PartOfSpeechAnnotation.class) : pos;
        typeAttribute.setType(pos != null ? pos : TypeAttribute.DEFAULT_TYPE);
        // Token character offsets
        int be = token.get(CharacterOffsetBeginAnnotation.class).intValue();
        int en = token.get(CharacterOffsetEndAnnotation.class).intValue();
        offsetAttribute.setOffset(be, en);
        // Token in-document position increment:
        positionAttribute.setPositionIncrement(1 + skippedTokens);
        skippedTokens = 0;
        return true;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        sentences = null;
        tokens = null;
        skippedTokens = -SENTENCE_GAP;
    }

    private boolean getNextSentence() {
        if (sentences == null)
            processInput();
        if (!sentences.hasNext())
            return false; // No more text
        tokens = sentences.next().get(TokensAnnotation.class).iterator();
        skippedTokens += SENTENCE_GAP;
        return true;
    }

    private boolean processInput() {
        Annotation annotation = new Annotation(IOUtils.slurpReader(input));
        pipeline.annotate(annotation);
        sentences = annotation.get(SentencesAnnotation.class).iterator();
        return true;
    }

}
