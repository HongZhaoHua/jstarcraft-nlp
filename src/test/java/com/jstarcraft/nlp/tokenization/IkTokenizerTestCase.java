package com.jstarcraft.nlp.tokenization;

import org.wltea.analyzer.core.IKSegmenter;

import com.jstarcraft.nlp.tokenization.ik.IkTokenizer;

public class IkTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer<? extends Token> getTokenizer() {
        return new IkTokenizer(new IKSegmenter(null, true));
    }

}
