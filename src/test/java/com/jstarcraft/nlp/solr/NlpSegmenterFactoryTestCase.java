package com.jstarcraft.nlp.solr;

import java.io.StringReader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Assert;
import org.junit.Test;

public abstract class NlpSegmenterFactoryTestCase {

    protected abstract Tokenizer getSegmenter();

    @Test
    public void testTokenize() throws Exception {
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
            System.out.println(term);
//          System.err.println(token.getTerm());
//          System.err.println(token.getBegin());
//          System.err.println(token.getEnd());
            Assert.assertEquals(term.toString().toLowerCase(), text.substring(offset.startOffset(), offset.endOffset()).toLowerCase());
        }
    }

}
