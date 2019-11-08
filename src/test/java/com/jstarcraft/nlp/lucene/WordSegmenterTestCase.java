package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;

import com.jstarcraft.nlp.lucene.word.WordTokenizer;

public class WordSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.FullSegmentation);
        WordTokenizer tokenizer = new WordTokenizer(segmentation);
        return tokenizer;
    }

}
