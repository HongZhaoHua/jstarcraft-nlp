package com.jstarcraft.nlp.tokenization;

import java.io.StringReader;
import java.text.BreakIterator;

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
import com.jstarcraft.nlp.lucene.NlpSegmenter;

public abstract class NlpTokenizerTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(NlpTokenizerTestCase.class);

    protected abstract NlpTokenizer<? extends NlpToken> getTokenizer();

    @Test
    public void testTokenize() throws Exception {
        String[] texts = {
                // 空格
                "     ",
                // 语句
                "中华人民共和国(People's Republic of China),简称'中国'" };

        for (String text : texts) {
            // 测试Iterator分词
            NlpTokenizer<? extends NlpToken> iterator = getTokenizer();
            Iterable<? extends NlpToken> tokens = iterator.tokenize(text);
            for (NlpToken token : tokens) {
                LOGGER.debug(StringUtility.format("term is {}, begin is {}, end is {}", token.getTerm(), token.getBegin(), token.getEnd()));
                Assert.assertEquals(token.getTerm().toLowerCase(), text.substring(token.getBegin(), token.getEnd()).toLowerCase());
            }

            // 测试Lucene分词
            try (Tokenizer tokenizer = new NlpSegmenter(BreakIterator.getWordInstance(), iterator)) {
                tokenizer.setReader(new StringReader(text));
                tokenizer.reset();
                while (tokenizer.incrementToken()) {
                    // 词元
                    CharTermAttribute term = tokenizer.getAttribute(CharTermAttribute.class);
                    // 偏移
                    OffsetAttribute offset = tokenizer.getAttribute(OffsetAttribute.class);
                    // 距离
                    PositionIncrementAttribute position = tokenizer.getAttribute(PositionIncrementAttribute.class);
                    // 词性
                    TypeAttribute type = tokenizer.getAttribute(TypeAttribute.class);
                    LOGGER.debug(StringUtility.format("term is {}, begin is {}, end is {}", term, offset.startOffset(), offset.endOffset()));
                    Assert.assertEquals(term.toString().toLowerCase(), text.substring(offset.startOffset(), offset.endOffset()).toLowerCase());
                }
            }
        }
    }

}
