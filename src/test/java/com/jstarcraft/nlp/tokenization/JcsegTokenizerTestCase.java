package com.jstarcraft.nlp.tokenization;

import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.ISegment;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.lionsoul.jcseg.tokenizer.core.SegmentFactory;

import com.jstarcraft.nlp.tokenization.jcseg.JcsegTokenizer;

public class JcsegTokenizerTestCase extends TokenizerTestCase {

    @Override
    protected Tokenizer<? extends Token> getTokenizer() {
        try {
            // 自动查找jcseg.properties配置
            JcsegTaskConfig configuration = new JcsegTaskConfig(true);
            // 默认单例词库
            ADictionary dictionary = DictionaryFactory.createSingletonDictionary(configuration);
            // 依据给定JcsegTaskConfig和ADictionary构建ISegment
            ISegment segment = SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE, new Object[] { configuration, dictionary });
            return new JcsegTokenizer(segment);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
