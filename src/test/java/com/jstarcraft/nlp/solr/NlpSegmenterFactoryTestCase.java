package com.jstarcraft.nlp.solr;

import java.io.StringReader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.core.utility.StringUtility;
import com.jstarcraft.nlp.tokenization.NlpTokenizerTestCase;

public abstract class NlpSegmenterFactoryTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(NlpTokenizerTestCase.class);

    protected abstract NlpSegmentFactory getSegmenterFactory() throws Exception;

    @Test
    public void testSegmentFactory() throws Exception {
        String[] texts = {
                // 空格
                "     ",
                // 语句
                "中华人民共和国(People's Republic of China),简称'中国'",
                // 文本
                "JStarCraft AI 1.0的目标是提供一个完整的Java机器学习(Machine Learning/ML)框架,作为人工智能在学术界与工业界的桥梁. 让相关领域的研发人员能够在各种软硬件环境/数据结构/算法/模型之间无缝切换. 涵盖了从数据处理到模型的训练与评估各个环节,支持硬件加速和并行计算,是最快最全的Java机器学习库." };

        NlpSegmentFactory factory = getSegmenterFactory();
        for (String text : texts) {
            // 测试Segmenter分词
            try (Tokenizer segmenter = factory.create();) {
                segmenter.setReader(new StringReader(text));
                segmenter.reset();
                while (segmenter.incrementToken()) {
                    // 词元
                    CharTermAttribute term = segmenter.getAttribute(CharTermAttribute.class);
                    // 偏移
                    OffsetAttribute offset = segmenter.getAttribute(OffsetAttribute.class);
                    // 距离
                    PositionIncrementAttribute position = segmenter.getAttribute(PositionIncrementAttribute.class);
                    // 词性
                    TypeAttribute type = segmenter.getAttribute(TypeAttribute.class);
                    LOGGER.debug(StringUtility.format("segmenter:term is {}, begin is {}, end is {}", term, offset.startOffset(), offset.endOffset()));
                    Assert.assertEquals(term.toString().toLowerCase(), text.substring(offset.startOffset(), offset.endOffset()).toLowerCase());
                }
            }
        }
    }

}
