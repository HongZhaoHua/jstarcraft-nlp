package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.util.WordConfTools;

import com.jstarcraft.nlp.lucene.word.WordTokenizer;

public class WordSegmenterTestCase extends NlpSegmenterTestCase {

    @Override
    protected Tokenizer getSegmenter() {
        // 可以配置到word.local.conf
        // 保持标点符号
        WordConfTools.set("keep.punctuation", "true");
        // 保持空格
        WordConfTools.set("keep.whitespace", "true");
        Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.FullSegmentation);
        WordTokenizer tokenizer = new WordTokenizer(segmentation);
        return tokenizer;
    }

}
