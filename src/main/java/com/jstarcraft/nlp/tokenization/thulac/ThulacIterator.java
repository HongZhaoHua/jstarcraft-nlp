package com.jstarcraft.nlp.tokenization.thulac;

import java.util.List;

import com.jstarcraft.nlp.tokenization.NlpIterator;

import io.github.yizhiru.thulac4j.Segmenter;

/**
 * THULAC分词器
 * 
 * @author Birdy
 *
 */
public class ThulacIterator implements NlpIterator<ThulacToken> {

    @Override
    public Iterable<ThulacToken> tokenize(CharSequence text) {
        List<String> iterator = Segmenter.segment(text.toString());
        ThulacToken iterable = new ThulacToken(iterator.iterator(), text.toString());
        return iterable;
    }

}
