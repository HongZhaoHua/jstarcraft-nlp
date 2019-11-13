package com.jstarcraft.nlp.solr.word;

import java.util.Map;
import java.util.Map.Entry;

import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.util.WordConfTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.word.WordTokenizer;

/**
 * word工厂
 * 
 * <pre>
 * word配置说明
 * https://github.com/ysc/word#4%E8%87%AA%E5%AE%9A%E4%B9%89%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6
 * https://github.com/ysc/word/blob/master/src/main/resources/word.conf
 * </pre>
 * 
 * @author Birdy
 *
 */
public class WordSegmentFactory extends NlpSegmentFactory<Segmentation> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordSegmentFactory.class);

    public WordSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        Segmentation segmentation = build(configurations);

        WordTokenizer tokenizer = new WordTokenizer(segmentation);
        return tokenizer;
    }

    @Override
    public Segmentation build(Map<String, String> configurations) {
        for (Entry<String, String> keyValue : configurations.entrySet()) {
            String key = keyValue.getKey();
            String value = keyValue.getValue();
            WordConfTools.set(key, value);
        }

        String algorithm = get(configurations, "algorithm", "FullSegmentation");
        Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.valueOf(algorithm));
        return segmentation;
    }

}
