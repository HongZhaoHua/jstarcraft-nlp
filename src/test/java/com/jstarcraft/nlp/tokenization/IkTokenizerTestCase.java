package com.jstarcraft.nlp.tokenization;

import org.wltea.analyzer.core.IKSegmenter;

import com.jstarcraft.nlp.tokenization.ik.IkTokenizer;

public class IkTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        return new IkTokenizer(new IKSegmenter(null, true));
    }

}
