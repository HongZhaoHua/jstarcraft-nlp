package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;

import com.jstarcraft.nlp.lucene.mynlp.MynlpTokenizer;
import com.mayabot.nlp.segment.Lexers;

public class MynlpTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        MynlpTokenizer tokenizer = new MynlpTokenizer(Lexers.core().filterReader(true, true));
        return tokenizer;
    }

}
