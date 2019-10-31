package com.jstarcraft.nlp.tokenization;

import org.junit.Assert;
import org.junit.Test;

public abstract class TokenizerTestCase {

    protected abstract Tokenizer<? extends Token> getTokenizer();

    @Test
    public void testTokenize() {
        Tokenizer<? extends Token> tokenizer = getTokenizer();
        String text = "中华人民共和国(People's Republic of China),简称'中国'";
        StringBuilder buffer = new StringBuilder();
        Iterable<? extends Token> tokens = tokenizer.tokenize(text);
        for (Token token : tokens) {
            buffer.append(token.getTerm());
            System.out.println(token.getTerm());
            System.out.println(token.getBegin());
            System.out.println(token.getEnd());
            Assert.assertEquals(token.getTerm().toLowerCase(), text.substring(token.getBegin(), token.getEnd()).toLowerCase());
        }
//        Assert.assertEquals(text, buffer.toString());
    }

}
