package com.jstarcraft.nlp.tokenization.corenlp;

import com.jstarcraft.nlp.tokenization.NlpIterator;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;

public class CoreNlpIterator implements NlpIterator<CoreNlpToken> {

    private Annotator annotator;
    
    public CoreNlpIterator(Annotator annotator) {
        this.annotator = annotator;
    }
    
    @Override
    public Iterable<CoreNlpToken> tokenize(CharSequence text) {
        Annotation annotation = new Annotation(text.toString());
        annotator.annotate(annotation);
        Iterable<CoreLabel> iterator = annotation.get(CoreAnnotations.TokensAnnotation.class);
        CoreNlpToken iterable = new CoreNlpToken(iterator.iterator());
        return iterable;
    }

}
