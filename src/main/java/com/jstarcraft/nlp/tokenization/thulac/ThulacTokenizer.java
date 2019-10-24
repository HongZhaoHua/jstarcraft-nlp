package com.jstarcraft.nlp.tokenization.thulac;

import java.util.List;

import com.jstarcraft.nlp.tokenization.Token;
import com.jstarcraft.nlp.tokenization.Tokenizer;

import io.github.yizhiru.thulac4j.Segmenter;

public class ThulacTokenizer implements Tokenizer {

    @Override
    public Iterable<Token> tokenize(CharSequence text) {
        List<String> iterator = Segmenter.segment(text.toString());
        ThulacToken iterable = new ThulacToken(iterator.iterator(), text.toString());
        return iterable;
    }

}
