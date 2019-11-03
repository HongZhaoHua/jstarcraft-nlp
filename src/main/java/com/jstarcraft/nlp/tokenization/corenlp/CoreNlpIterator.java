package com.jstarcraft.nlp.tokenization.corenlp;

import java.util.Collections;

import com.jstarcraft.core.utility.StringUtility;
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
        Iterable<CoreLabel> iterator;
        if (StringUtility.isBlank(text)) {
            // 空格无需分词
            iterator = Collections.EMPTY_LIST;
        } else {
            Annotation annotation = new Annotation(text.toString());
            annotator.annotate(annotation);
            iterator = annotation.get(CoreAnnotations.TokensAnnotation.class);
        }
        CoreNlpToken iterable = new CoreNlpToken(iterator.iterator());
        return iterable;
    }

}
