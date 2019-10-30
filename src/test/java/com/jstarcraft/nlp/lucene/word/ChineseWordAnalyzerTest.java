package com.jstarcraft.nlp.lucene.word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apdplat.word.util.WordConfTools;
import org.junit.Assert;
import org.junit.Test;

public class ChineseWordAnalyzerTest {

    @Test
    public void test1() {
        try {
            Analyzer analyzer = new ChineseWordAnalyzer();
            TokenStream tokenStream = analyzer.tokenStream("text", "杨尚川是APDPlat应用级产品开发平台的作者");
            List<String> words = new ArrayList<>();
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
                words.add(charTermAttribute.toString());
            }
            tokenStream.close();
            String expResult = "[杨尚川, 是, apdplat, 应用级, 产品, 开发, 平台, 的, 作者]";
            if ("bigram".equals(WordConfTools.get("ngram", "bigram"))) {
                expResult = "[杨尚川, 是, apdplat, 应用, 级, 产品, 开发, 平台, 的, 作者]";
            }
            Assert.assertEquals(expResult, words.toString());
        } catch (IOException e) {
            Assert.fail("分词出错" + e.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            Analyzer analyzer = new ChineseWordAnalyzer();
            TokenStream tokenStream = analyzer.tokenStream("text", "叔叔亲了我妈妈也亲了我");
            List<String> words = new ArrayList<>();
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
                words.add(charTermAttribute.toString());
            }
            tokenStream.close();
            String expResult = "[叔叔, 亲了, 我, 妈妈, 也, 亲了, 我]";
            Assert.assertEquals(expResult, words.toString());
        } catch (IOException e) {
            Assert.fail("分词出错" + e.getMessage());
        }
    }

}
