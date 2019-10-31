package com.jstarcraft.nlp.tokenization;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.jstarcraft.nlp.tokenization.hanlp.HanlpTokenizer;

public class HanlpTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer<? extends Token> getTokenizer() {
        Segment segment = HanLP.newSegment();
        segment.enableOffset(true);
        return new HanlpTokenizer(segment);
    }

}
