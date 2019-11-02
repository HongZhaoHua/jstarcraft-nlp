package com.jstarcraft.nlp.tokenization;

import org.junit.Assert;
import org.junit.Test;

public abstract class NlpIteratorTestCase {

    protected abstract NlpIterator<? extends NlpToken> getTokenizer();

    @Test
    public void testTokenize() {
        NlpIterator<? extends NlpToken> tokenizer = getTokenizer();
        String text = "中华人民共和国(People's Republic of China),简称'中国'";
        StringBuilder buffer = new StringBuilder();
        Iterable<? extends NlpToken> tokens = tokenizer.tokenize(text);
        for (NlpToken token : tokens) {
            buffer.append(token.getTerm());
            System.out.println(token.getTerm());
            System.out.println(token.getBegin());
            System.out.println(token.getEnd());
            Assert.assertEquals(token.getTerm().toLowerCase(), text.substring(token.getBegin(), token.getEnd()).toLowerCase());
        }
//        Assert.assertEquals(text, buffer.toString());
    }

}
