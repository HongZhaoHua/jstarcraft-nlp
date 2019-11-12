package com.jstarcraft.nlp.tokenization;

import com.jstarcraft.nlp.tokenization.thulac.ThulacTokenizer;

import io.github.yizhiru.thulac4j.SPChineseTokenizer;
import io.github.yizhiru.thulac4j.Segmenter;
import io.github.yizhiru.thulac4j.ThulacAdapter;
import io.github.yizhiru.thulac4j.util.ModelPaths;

public class ThulacTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected NlpTokenizer<? extends NlpToken> getTokenizer() {
        SPChineseTokenizer tokenizer = ThulacAdapter.getThulac(Segmenter.class.getResourceAsStream(ModelPaths.SEGMENTER_WEIGHT_PATH), Segmenter.class.getResourceAsStream(ModelPaths.SEGMENTER_FEATURE_PATH), Segmenter.class.getResourceAsStream(ModelPaths.SEGMENTER_LABEL_PATH));
        return new ThulacTokenizer(tokenizer);
    }

}
