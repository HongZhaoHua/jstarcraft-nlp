package com.jstarcraft.nlp.tokenization;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.jstarcraft.nlp.tokenization.hanlp.HanlpIterator;

public class HanlpIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        Segment segment = HanLP.newSegment();
        segment.enableOffset(true);
        return new HanlpIterator(segment);
    }

}
