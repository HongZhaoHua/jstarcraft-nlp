package com.jstarcraft.nlp.solr.jcseg;

import java.util.Map;

import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.ISegment;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.lionsoul.jcseg.tokenizer.core.SegmentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.jcseg.JcsegTokenizer;

/**
 * Jcseg工厂
 * 
 * <pre>
 * Jcseg配置说明
 * https://github.com/lionsoul2014/jcseg#jcseg%E4%B8%AD%E6%96%87%E5%88%86%E8%AF%8D
 * </pre>
 * 
 * @author Birdy
 *
 */
public class JcsegSegmentFactory extends NlpSegmentFactory<ISegment> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JcsegSegmentFactory.class);

    public JcsegSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        ISegment segment = build(configurations);

        JcsegTokenizer tokenizer = new JcsegTokenizer(segment);
        return tokenizer;
    }

    @Override
    public ISegment build(Map<String, String> configurations) {
        String configuration = get(configurations, "mode", "nlp");
        int mode;
        switch (configuration) {
        case "simple":
            mode = JcsegTaskConfig.SIMPLE_MODE;
            break;
        case "complex":
            mode = JcsegTaskConfig.COMPLEX_MODE;
            break;
        case "detech":
            mode = JcsegTaskConfig.DETECT_MODE;
            break;
        case "search":
            mode = JcsegTaskConfig.SEARCH_MODE;
            break;
        case "delimiter":
            mode = JcsegTaskConfig.DELIMITER_MODE;
            break;
        case "nlp":
            mode = JcsegTaskConfig.NLP_MODE;
            break;
        default:
            throw new IllegalArgumentException();
        }

        JcsegTaskConfig config = new JcsegTaskConfig(true);

        ADictionary dictionary = DictionaryFactory.createSingletonDictionary(config);

        try {
            ISegment segment = SegmentFactory.createJcseg(mode, new Object[] { config, dictionary });
            return segment;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
