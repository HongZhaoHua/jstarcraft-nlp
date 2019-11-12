package com.jstarcraft.nlp.solr.jieba;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.jstarcraft.core.utility.KeyValue;
import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.jieba.JiebaTokenizer;

/**
 * jieba工厂
 * 
 * <pre>
 * jieba配置说明
 * https://github.com/huaban/jieba-analysis#%E6%94%AF%E6%8C%81%E5%88%86%E8%AF%8D%E6%A8%A1%E5%BC%8F
 * </pre>
 * 
 * @author Birdy
 *
 */
public class JiebaSegmentFactory extends NlpSegmentFactory<KeyValue<JiebaSegmenter, SegMode>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JiebaSegmentFactory.class);

    public JiebaSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        KeyValue<JiebaSegmenter, SegMode> keyValue = build(configurations);
        JiebaSegmenter segmenter = keyValue.getKey();
        SegMode mode = keyValue.getValue();

        JiebaTokenizer tokenizer = new JiebaTokenizer(segmenter, mode);
        return tokenizer;
    }

    @Override
    public KeyValue<JiebaSegmenter, SegMode> build(Map<String, String> configurations) {
        String configuration = get(configurations, "mode", "search");
        SegMode mode;
        switch (configuration) {
        case "index":
            mode = SegMode.INDEX;
            break;
        case "search":
            mode = SegMode.SEARCH;
            break;
        default:
            throw new IllegalArgumentException();
        }

        JiebaSegmenter segmenter = new JiebaSegmenter();

        return new KeyValue<>(segmenter, mode);
    }

}
