package com.jstarcraft.nlp.lucene;

import java.io.StringReader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Assert;
import org.junit.Test;

public abstract class NlpSegmenterTestCase {

    protected abstract Tokenizer getTokenizer();

    @Test
    public void testTokenize() throws Exception {
        Tokenizer tokenizer = getTokenizer();
        String text = "中华人民共和国(People's Republic of China),简称'中国'";
        tokenizer.setReader(new StringReader(text));
        tokenizer.reset();
        while (tokenizer.incrementToken()) {
            // 词元
            CharTermAttribute term = tokenizer.getAttribute(CharTermAttribute.class);
            // 偏移量
            OffsetAttribute offset = tokenizer.getAttribute(OffsetAttribute.class);
            // 距离
            PositionIncrementAttribute position = tokenizer.getAttribute(PositionIncrementAttribute.class);
            // 词性
            TypeAttribute type = tokenizer.getAttribute(TypeAttribute.class);
            System.out.println(term);
//          System.err.println(token.getTerm());
//          System.err.println(token.getBegin());
//          System.err.println(token.getEnd());
            Assert.assertEquals(term.toString().toLowerCase(), text.substring(offset.startOffset(), offset.endOffset()).toLowerCase());
        }
    }

}
