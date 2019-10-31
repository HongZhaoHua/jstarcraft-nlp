package com.jstarcraft.nlp.tokenization;

import com.jstarcraft.nlp.tokenization.mynlp.MynlpTokenizer;
import com.mayabot.nlp.segment.Lexer;
import com.mayabot.nlp.segment.Lexers;

public class MynlpTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer<? extends Token> getTokenizer() {
        Lexer lexer = Lexers.core();
        return new MynlpTokenizer(lexer);
    }

}
