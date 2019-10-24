package com.jstarcraft.nlp;

import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;

import com.jstarcraft.nlp.tokenization.Tokenizer;
import com.jstarcraft.nlp.tokenization.word.WordTokenizer;

public class WordTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.FullSegmentation);
        return new WordTokenizer(segmentation);
    }

}
