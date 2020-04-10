package com.jstarcraft.nlp.solr.ik;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.core.IKSegmenter;

import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.ik.IkTokenizer;

/**
 * Ik工厂
 * 
 * <pre>
 * Ik配置说明
 * https://gitee.com/wltea/IK-Analyzer-2012FF/blob/master/IKAnalyzer%E4%B8%AD%E6%96%87%E5%88%86%E8%AF%8D%E5%99%A8V2012_FF%E4%BD%BF%E7%94%A8%E6%89%8B%E5%86%8C.pdf
 * </pre>
 * 
 * @author Birdy
 *
 */
public class IkSegmentFactory extends NlpSegmentFactory<IKSegmenter> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IkSegmentFactory.class);

    public IkSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        IKSegmenter segmenter = build(configurations);

        IkTokenizer tokenizer = new IkTokenizer(segmenter);
        return tokenizer;
    }

    @Override
    public IKSegmenter build(Map<String, String> configurations) {
        Boolean useSmart = getBoolean(configurations, "useSmart", false);
        IKSegmenter segmenter = new IKSegmenter(null, useSmart);

        return segmenter;
    }

}
