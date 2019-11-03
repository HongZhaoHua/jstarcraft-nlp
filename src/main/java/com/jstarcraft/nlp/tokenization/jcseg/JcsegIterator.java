package com.jstarcraft.nlp.tokenization.jcseg;

import java.io.StringReader;
import java.util.LinkedList;

import org.lionsoul.jcseg.tokenizer.core.ISegment;
import org.lionsoul.jcseg.tokenizer.core.IWord;

import com.jstarcraft.nlp.tokenization.NlpIterator;

/**
 * Jcseg分词器
 * 
 * @author Birdy
 *
 */
public class JcsegIterator implements NlpIterator<JcsegToken> {

    private ISegment segment;

    public JcsegIterator(ISegment segment) {
        this.segment = segment;
    }

    @Override
    public Iterable<JcsegToken> tokenize(CharSequence text) {
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
