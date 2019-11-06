package com.jstarcraft.nlp.lucene.jcseg;

import java.io.IOException;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.JcsegException;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jcseg tokenizer factory class for solr
 * 
 * @author chenxin<chenxin619315@gmail.com>
 */
public class JcsegTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(JcsegTokenizerFactory.class);

    private int mode;

    private JcsegTaskConfig config = null;

    private ADictionary dic = null;

    /**
     * set the mode arguments in the schema.xml configuration file to change the
     * segment mode for Jcseg
     * 
     * @throws IOException
     * 
     * @see TokenizerFactory#TokenizerFactory(Map)
     */
    public JcsegTokenizerFactory(Map<String, String> configuration) throws IOException {
        super(configuration);

        String _mode = configuration.get("mode");
        if (_mode == null) {
            mode = JcsegTaskConfig.SEARCH_MODE;
        } else {
            _mode = _mode.toLowerCase();
            if ("simple".equals(_mode)) {
                mode = JcsegTaskConfig.SIMPLE_MODE;
            } else if ("detect".equals(_mode)) {
                mode = JcsegTaskConfig.DETECT_MODE;
            } else if ("search".equals(_mode)) {
                mode = JcsegTaskConfig.SEARCH_MODE;
            } else if ("nlp".equals(_mode)) {
                mode = JcsegTaskConfig.NLP_MODE;
            } else if ("delimiter".equals(_mode)) {
                mode = JcsegTaskConfig.DELIMITER_MODE;
            } else {
                mode = JcsegTaskConfig.COMPLEX_MODE;
            }
        }

        // initialize the task configuration and the dictionary
        config = new JcsegTaskConfig(true);
        // check and apply this-level Jcseg settings
        // TODO 此段代码在Jcseg-2.6.0之后才生效,暂时屏蔽.
//        for (Entry<String, String> entry : args.entrySet()) {
//            if (entry.getKey().startsWith("jcseg_")) {
//                config.set(entry.getKey().replace("jcseg_", "jcseg."), entry.getValue());
//            }
//        }

        dic = DictionaryFactory.createSingletonDictionary(config);
    }

    public void setConfig(JcsegTaskConfig config) {
        this.config = config;
    }

    public void setDict(ADictionary dic) {
        this.dic = dic;
    }

    public JcsegTaskConfig getTaskConfig() {
        return config;
    }

    public ADictionary getDict() {
        return dic;
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        try {
            return new JcsegTokenizer(mode, config, dic);
        } catch (JcsegException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
