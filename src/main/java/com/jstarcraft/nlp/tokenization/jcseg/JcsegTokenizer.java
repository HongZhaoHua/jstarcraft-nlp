package com.jstarcraft.nlp.tokenization.jcseg;

import java.io.StringReader;
import java.util.LinkedList;

import org.lionsoul.jcseg.tokenizer.core.ISegment;
import org.lionsoul.jcseg.tokenizer.core.IWord;

import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

public class JcsegTokenizer implements Tokenizer {

    private ISegment segment;

    public JcsegTokenizer(ISegment segment) {
        this.segment = segment;
    }

    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        try {
            segment.reset(new StringReader(text.toString()));
            LinkedList<IWord> iterator = new LinkedList<>();
            while (true) {
                IWord word = segment.next();
                if (word != null) {
                    iterator.add(word);
                } else {
                    break;
                }
            }
            JcsegToken iterable = new JcsegToken(iterator.iterator());
            return iterable;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
