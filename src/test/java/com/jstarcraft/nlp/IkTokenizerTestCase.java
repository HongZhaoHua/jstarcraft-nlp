package com.jstarcraft.nlp;

import org.wltea.analyzer.core.IKSegmenter;

import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.ik.IkTokenizer;

public class IkTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        return new IkTokenizer(new IKSegmenter(null, true));
    }

}
