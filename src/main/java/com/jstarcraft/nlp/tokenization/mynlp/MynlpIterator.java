package com.jstarcraft.nlp.tokenization.mynlp;

import com.jstarcraft.nlp.tokenization.NlpIterator;
import com.mayabot.nlp.segment.Lexer;
import com.mayabot.nlp.segment.Sentence;

/**
 * MYNLP分词器
 * 
 * @author Birdy
 *
 */
public class MynlpIterator implements NlpIterator<MynlpToken> {

    private Lexer lexer;

    public MynlpIterator(Lexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public Iterable<MynlpToken> tokenize(CharSequence text) {
        Sentence sentence = lexer.scan(text.toString());
        MynlpToken iterable = new MynlpToken(sentence.iterator());
        return iterable;
    }

}
