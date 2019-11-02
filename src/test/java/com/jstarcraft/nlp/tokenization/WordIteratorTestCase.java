package com.jstarcraft.nlp.tokenization;

import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.util.WordConfTools;

import com.jstarcraft.nlp.tokenization.word.WordIterator;

public class WordIteratorTestCase extends NlpIteratorTestCase {

    @Override
    protected NlpIterator<? extends NlpToken> getTokenizer() {
        // 保持标点符号
        WordConfTools.set("keep.punctuation", "true");
        // 保持空格
        WordConfTools.set("keep.whitespace", "true");
        Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.FullSegmentation);
        return new WordIterator(segmentation);
    }

}
