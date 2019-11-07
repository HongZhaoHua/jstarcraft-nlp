package com.jstarcraft.nlp.tokenization;

import com.jstarcraft.nlp.tokenization.thulac.ThulacTokenizer;

public class ThulacTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        return new ThulacTokenizer();
    }

}
