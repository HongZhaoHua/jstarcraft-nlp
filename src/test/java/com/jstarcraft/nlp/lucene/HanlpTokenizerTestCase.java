package com.jstarcraft.nlp.lucene;

import java.util.Collections;

import org.apache.lucene.analysis.Tokenizer;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.jstarcraft.nlp.lucene.hanlp.HanlpTokenScanner;

public class HanlpTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        Segment segment = HanLP.newSegment();
        segment.enableOffset(true);
        HanlpTokenScanner tokenizer = new HanlpTokenScanner(segment, Collections.EMPTY_SET);
        return tokenizer;
    }

}
