package com.jstarcraft.nlp.tokenization.corenlp;

import java.util.Collections;

import com.jstarcraft.core.utility.StringUtility;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;

/**
 * CoreNLP分词器
 * 
 * @author Birdy
 *
 */
public class CorenlpTokenizer implements NlpTokenizer<CorenlpToken> {

    private Annotator annotator;

    public CorenlpTokenizer(Annotator annotator) {
        this.annotator = annotator;
    }

    @Override
    public Iterable<CorenlpToken> tokenize(CharSequence text) {
        Iterable<CoreLabel> iterator;
        if (StringUtility.isBlank(text)) {
            // 空格无需分词
            iterator = Collections.EMPTY_LIST;
        } else {
            Annotation annotation = new Annotation(text.toString());
            annotator.annotate(annotation);
            iterator = annotation.get(CoreAnnotations.TokensAnnotation.class);
        }
        CorenlpToken iterable = new CorenlpToken(iterator.iterator());
        return iterable;
    }

}
