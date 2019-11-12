package com.jstarcraft.nlp.solr.thulac;

import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.thulac.ThulacTokenizer;

import io.github.yizhiru.thulac4j.SPChineseTokenizer;
import io.github.yizhiru.thulac4j.Segmenter;
import io.github.yizhiru.thulac4j.ThulacAdapter;
import io.github.yizhiru.thulac4j.util.ModelPaths;

/**
 * THULAC工厂
 * 
 * <pre>
 * THULAC配置说明
 * https://github.com/yizhiru/thulac4j/wiki/%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B#%E4%BD%BF%E7%94%A8
 * </pre>
 * 
 * @author Birdy
 *
 */
public class ThulacSegmentFactory extends NlpSegmentFactory<SPChineseTokenizer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThulacSegmentFactory.class);

    public ThulacSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        SPChineseTokenizer thulac = build(configurations);

        ThulacTokenizer tokenizer = new ThulacTokenizer(thulac);
        return tokenizer;
    }

    @Override
    public SPChineseTokenizer build(Map<String, String> configurations) {
        String weightPath = get(configurations, "weightPath", ModelPaths.SEGMENTER_WEIGHT_PATH);
        InputStream weightStream = Segmenter.class.getResourceAsStream(weightPath);

        String featurePath = get(configurations, "featurePath", ModelPaths.SEGMENTER_FEATURE_PATH);
        InputStream featureStream = Segmenter.class.getResourceAsStream(featurePath);

        String labelPath = get(configurations, "labelPath", ModelPaths.SEGMENTER_LABEL_PATH);
        InputStream labelStream = Segmenter.class.getResourceAsStream(labelPath);

        SPChineseTokenizer tokenizer = ThulacAdapter.getThulac(weightStream, featureStream, labelStream);
        return tokenizer;
    }

}
