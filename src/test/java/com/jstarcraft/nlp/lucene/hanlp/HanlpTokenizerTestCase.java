package com.jstarcraft.nlp.lucene.hanlp;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hankcs.hanlp.HanLP;

public class HanlpTokenizerTestCase {

    Tokenizer tokenizer;

    @Before
    @BeforeEach
    public void setUp() throws Exception {
        tokenizer = new HanlpTokenizer(HanLP.newSegment().enableJapaneseNameRecognize(true).enableIndexMode(true), null);
        tokenizer.setReader(new StringReader("一套涵盖核心编程,人工智能,数字图像处理,自然语言处理,推荐与搜索,云服务领域的Java框架"));
        tokenizer.reset();
    }

    @Test
    public void testIncrementToken() throws Exception {
        while (tokenizer.incrementToken()) {
            CharTermAttribute attribute = tokenizer.getAttribute(CharTermAttribute.class);
            // 偏移量
            OffsetAttribute offsetAtt = tokenizer.getAttribute(OffsetAttribute.class);
            // 距离
            PositionIncrementAttribute positionAttr = tokenizer.getAttribute(PositionIncrementAttribute.class);
            // 词性
            TypeAttribute typeAttr = tokenizer.getAttribute(TypeAttribute.class);
            System.out.printf("[%d:%d %d] %s/%s\n", offsetAtt.startOffset(), offsetAtt.endOffset(), positionAttr.getPositionIncrement(), attribute, typeAttr.type());
        }
    }

    @Test
    public void testMultiText() throws Exception {
        String[] sentences = new String[] { "中华人民共和国", "地大物博" };
        tokenizer = new HanlpTokenizer(HanLP.newSegment().enableJapaneseNameRecognize(true).enableIndexMode(true), null);
        for (String sentence : sentences) {
            tokenizer.setReader(new StringReader(sentence));
            tokenizer.reset();
            testIncrementToken();
            tokenizer.close();
        }
    }

    @Test
    public void testPinyinTokenFilter() throws Exception {
        Map<String, String> arguments = new HashMap<>();
        arguments.put("original", "true");
        arguments.put("full", "true");
        arguments.put("first", "true");
        HanlpPinyinTokenFilterFactory factory = new HanlpPinyinTokenFilterFactory(arguments);
        TokenStream tokenStream = factory.create(tokenizer);
        while (tokenStream.incrementToken()) {
            CharTermAttribute attribute = tokenizer.getAttribute(CharTermAttribute.class);
            // 偏移量
            OffsetAttribute offsetAtt = tokenizer.getAttribute(OffsetAttribute.class);
            // 距离
            PositionIncrementAttribute positionAttr = tokenizer.getAttribute(PositionIncrementAttribute.class);
            // 词性
            TypeAttribute typeAttr = tokenizer.getAttribute(TypeAttribute.class);
            System.out.printf("[%d:%d %d] %s/%s\n", offsetAtt.startOffset(), offsetAtt.endOffset(), positionAttr.getPositionIncrement(), attribute, typeAttr.type());
        }
    }

}
