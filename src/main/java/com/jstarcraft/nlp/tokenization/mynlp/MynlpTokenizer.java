package com.jstarcraft.nlp.tokenization.mynlp;

import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.mayabot.nlp.segment.Lexer;
import com.mayabot.nlp.segment.Sentence;

public class MynlpTokenizer implements Tokenizer {

    private Lexer lexer;

    public MynlpTokenizer(Lexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        Sentence sentence = lexer.scan(text.toString());
        MynlpToken iterable = new MynlpToken(sentence.iterator());
        return iterable;
    }

}
