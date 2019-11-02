package com.jstarcraft.nlp.tokenization;

import com.jstarcraft.nlp.tokenization.mynlp.MynlpIterator;
import com.mayabot.nlp.segment.Lexer;
import com.mayabot.nlp.segment.Lexers;

public class MynlpIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        Lexer lexer = Lexers.core();
        return new MynlpIterator(lexer);
    }

}
