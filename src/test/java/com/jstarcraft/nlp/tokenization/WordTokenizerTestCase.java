package com.jstarcraft.nlp.tokenization;

import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.util.WordConfTools;

import com.jstarcraft.nlp.tokenization.word.WordTokenizer;

public class WordTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        // 保持标点符号
        WordConfTools.set("keep.punctuation", "true");
        // 保持空格
        WordConfTools.set("keep.whitespace", "true");
        Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.FullSegmentation);
        return new WordTokenizer(segmentation);
    }

}
