package com.jstarcraft.nlp.lucene.corenlp;

import java.io.IOException;
import java.util.Iterator;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.AttributeFactory;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.util.CoreMap;

public class CoreNLPTokenizer extends Tokenizer {

    AnnotationPipeline pipeline;

    CharTermAttribute termAt;

    TypeAttribute typeAt;

    OffsetAttribute offsetAt;

    PositionIncrementAttribute positionAt;

    Iterator<CoreMap> sentences = null;

    Iterator<CoreLabel> tokens = null;

    int skippedTokens;

    final static int SENTENCE_GAP = 10;

    public CoreNLPTokenizer(AnnotationPipeline pipeline) {
        this(DEFAULT_TOKEN_ATTRIBUTE_FACTORY, pipeline);
    }

    public CoreNLPTokenizer(AttributeFactory factory, AnnotationPipeline pipeline) {
        super(factory);
        this.pipeline = pipeline;
        this.termAt = addAttribute(CharTermAttribute.class);
        this.typeAt = addAttribute(TypeAttribute.class);
        this.offsetAt = addAttribute(OffsetAttribute.class);
        this.positionAt = addAttribute(PositionIncrementAttribute.class);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        sentences = null;
        tokens = null;
        skippedTokens = -SENTENCE_GAP;
    }

    @Override
    public final boolean incrementToken() {
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
        termAt.setLength(0);
        termAt.append(word);
        // NER or part of speech annotation
        String pos = token.get(NamedEntityTagAnnotation.class);
        pos = (pos == null || "O".equals(pos)) ? token.get(PartOfSpeechAnnotation.class) : pos;
        typeAt.setType(pos != null ? pos : TypeAttribute.DEFAULT_TYPE);
        // Token character offsets
        int be = token.get(CharacterOffsetBeginAnnotation.class).intValue();
        int en = token.get(CharacterOffsetEndAnnotation.class).intValue();
        offsetAt.setOffset(be, en);
        // Token in-document position increment:
        positionAt.setPositionIncrement(1 + skippedTokens);
        skippedTokens = 0;
        return true;
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
