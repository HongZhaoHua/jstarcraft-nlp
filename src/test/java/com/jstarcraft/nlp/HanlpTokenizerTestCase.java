package com.jstarcraft.nlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.hanlp.HanlpTokenizer;

public class HanlpTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        Segment segment = HanLP.newSegment();
        segment.enableOffset(true);
        return new HanlpTokenizer(segment);
    }

}
