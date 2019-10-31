package com.jstarcraft.nlp.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;

import com.jstarcraft.nlp.lucene.jcseg.JcsegTokenizer;

public class JcsegTokenizerTestCase extends NlpTokenizerTestCase {

    @Override
    protected Tokenizer getTokenizer() {
        try {
            // 自动查找jcseg.properties配置
            JcsegTaskConfig configuration = new JcsegTaskConfig(true);
            // 默认单例词库
            ADictionary dictionary = DictionaryFactory.createSingletonDictionary(configuration);
            // 依据给定JcsegTaskConfig和ADictionary构建ISegment
            JcsegTokenizer tokenizer = new JcsegTokenizer(JcsegTaskConfig.COMPLEX_MODE, configuration, dictionary);
            return tokenizer;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
