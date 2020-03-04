package com.jstarcraft.nlp.lucene;

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

public abstract class NlpSegmenterTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(NlpSegmenterTestCase.class);

    protected abstract Tokenizer getSegmenter();

    @Test
    public void testSegmenter() throws Exception {
        Tokenizer segmenter = getSegmenter();
        String text = "中华人民共和国(People's Republic of China),简称'中国'";
        segmenter.setReader(new StringReader(text));
        segmenter.reset();
        while (segmenter.incrementToken()) {
            // 词元
            CharTermAttribute term = segmenter.getAttribute(CharTermAttribute.class);
            // 偏移量
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
