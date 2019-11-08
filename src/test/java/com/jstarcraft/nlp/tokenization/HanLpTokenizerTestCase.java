package com.jstarcraft.nlp.tokenization;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.jstarcraft.nlp.tokenization.hanlp.HanLpTokenizer;

public class HanLpTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        Segment segment = HanLP.newSegment();
        segment.enableOffset(true);
        return new HanLpTokenizer(segment);
    }

}
