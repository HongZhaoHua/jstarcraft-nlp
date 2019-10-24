package com.jstarcraft.nlp.tokenization;

import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

public abstract class TokenizerTestCase {

    protected abstract Tokenizer getTokenizer();

    @Test
    public void testTokenize() {
        Tokenizer tokenizer = getTokenizer();
        String text = "中华人民共和国(People's Republic of China),简称'中国'";
        StringBuilder buffer = new StringBuilder();
        Iterable<Token> tokens = tokenizer.tokenize(text);
        for (Token token : tokens) {
            buffer.append(token.getTerm());
            System.err.println(token.getTerm());
            System.err.println(token.getBegin());
            System.err.println(token.getEnd());
            Assert.assertEquals(token.getTerm().toLowerCase(), text.substring(token.getBegin(), token.getEnd()).toLowerCase());
        }
//        Assert.assertEquals(text, buffer.toString());
    }

}
