package com.jstarcraft.nlp.lucene.word;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.util.WordConfTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lucene中文分词器工厂
 * 
 * @author 杨尚川
 */
public class WordTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordTokenizerFactory.class);

    private Segmentation segmentation = null;

    public WordTokenizerFactory(Map<String, String> args) {
        super(args);
        if (args != null) {
            String conf = args.get("conf");
            if (conf != null) {
                // 强制覆盖默认配置
                WordConfTools.forceOverride(conf);
            } else {
                LOGGER.info("没有指定conf参数");
            }
            String algorithm = args.get("segAlgorithm");
            if (algorithm != null) {
                try {
                    SegmentationAlgorithm segmentationAlgorithm = SegmentationAlgorithm.valueOf(algorithm);
                    segmentation = SegmentationFactory.getSegmentation(segmentationAlgorithm);
                    LOGGER.info("使用指定分词算法：" + algorithm);
                } catch (Exception e) {
                    LOGGER.error("参数segAlgorithm指定的值错误：" + algorithm);
                    LOGGER.error("参数segAlgorithm可指定的值有：");
                    for (SegmentationAlgorithm sa : SegmentationAlgorithm.values()) {
                        LOGGER.error("\t" + sa.name());
                    }
                }
            } else {
                LOGGER.info("没有指定segAlgorithm参数");
            }
        }
        if (segmentation == null) {
            segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.BidirectionalMaximumMatching);
            LOGGER.info("使用默认分词算法：" + SegmentationAlgorithm.BidirectionalMaximumMatching);
        }
    }

    @Override
    public Tokenizer create(AttributeFactory af) {
        return new WordTokenizer(segmentation);
    }

}
