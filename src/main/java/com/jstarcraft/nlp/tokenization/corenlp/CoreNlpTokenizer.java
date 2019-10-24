package com.jstarcraft.nlp.tokenization.corenlp;

import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;

public class CoreNlpTokenizer implements Tokenizer {

    private Annotator annotator;
    
    public CoreNlpTokenizer(Annotator annotator) {
        this.annotator = annotator;
    }
    
    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        Annotation annotation = new Annotation(text.toString());
        annotator.annotate(annotation);
        Iterable<CoreLabel> iterator = annotation.get(CoreAnnotations.TokensAnnotation.class);
        CoreNlpToken iterable = new CoreNlpToken(iterator.iterator());
        return iterable;
    }

}
