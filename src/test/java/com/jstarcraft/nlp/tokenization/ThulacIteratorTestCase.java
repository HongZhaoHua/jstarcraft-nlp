package com.jstarcraft.nlp.tokenization;

import com.jstarcraft.nlp.tokenization.thulac.ThulacIterator;

public class ThulacIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        return new ThulacIterator();
    }

}
