package com.jstarcraft.nlp.tokenization;

import org.wltea.analyzer.core.IKSegmenter;

import com.jstarcraft.nlp.tokenization.ik.IkIterator;

public class IkIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        return new IkIterator(new IKSegmenter(null, true));
    }

}
