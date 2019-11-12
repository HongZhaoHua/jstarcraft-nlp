package com.jstarcraft.nlp.tokenization.thulac;

import java.util.List;

import com.jstarcraft.nlp.tokenization.NlpTokenizer;

import io.github.yizhiru.thulac4j.SPChineseTokenizer;
import io.github.yizhiru.thulac4j.term.TokenItem;

/**
 * THULAC分词器
 * 
 * @author Birdy
 *
 */
public class ThulacTokenizer implements NlpTokenizer<ThulacToken> {

    private SPChineseTokenizer tokenizer;

    public ThulacTokenizer(SPChineseTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public Iterable<ThulacToken> tokenize(CharSequence text) {
        List<TokenItem> iterator = tokenizer.tokenize(text.toString());
        ThulacToken iterable = new ThulacToken(iterator.iterator(), text.toString());
        return iterable;
    }

}
