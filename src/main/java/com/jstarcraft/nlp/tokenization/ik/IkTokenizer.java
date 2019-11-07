package com.jstarcraft.nlp.tokenization.ik;

import java.io.StringReader;
import java.util.LinkedList;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import com.jstarcraft.nlp.tokenization.NlpTokenizer;

/**
 * IK分词器
 * 
 * @author Birdy
 *
 */
public class IkTokenizer implements NlpTokenizer<IkToken> {

    private IKSegmenter segmenter;

    public IkTokenizer(IKSegmenter segmenter) {
        this.segmenter = segmenter;
    }

    @Override
    public Iterable<IkToken> tokenize(CharSequence text) {
        try {
            segmenter.reset(new StringReader(text.toString()));
            LinkedList<Lexeme> iterator = new LinkedList<>();
            while (true) {
                Lexeme lexeme = segmenter.next();
                if (lexeme != null) {
                    iterator.add(lexeme);
                } else {
                    break;
                }
            }
            IkToken iterable = new IkToken(iterator.iterator());
            return iterable;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
