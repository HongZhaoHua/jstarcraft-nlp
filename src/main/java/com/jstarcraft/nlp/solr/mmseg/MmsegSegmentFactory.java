package com.jstarcraft.nlp.solr.mmseg;

import java.io.File;
import java.io.StringReader;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;
import com.jstarcraft.core.utility.StringUtility;
import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.mmseg.MmsegTokenizer;

/**
 * MMSEG工厂
 * 
 * <pre>
 * MMSEG配置说明
 * https://github.com/chenlb/mmseg4j-core#example
 * </pre>
 * 
 * @author Birdy
 *
 */
public class MmsegSegmentFactory extends NlpSegmentFactory<MMSeg> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MmsegSegmentFactory.class);

    public MmsegSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        MMSeg segment = build(configurations);

        MmsegTokenizer tokenizer = new MmsegTokenizer(segment);
        return tokenizer;
    }

    @Override
    public MMSeg build(Map<String, String> configurations) {
        Dictionary dictionary;
        String dictionaryPath = get(configurations, "dictionaryPath");
        if (StringUtility.isBlank(dictionaryPath)) {
            dictionary = Dictionary.getInstance();
        } else {
            File file = new File(dictionaryPath);
            dictionary = Dictionary.getInstance(file);
        }

        String configuration = get(configurations, "mode", "MaxWord");
        Seg seg = null;
        switch (configuration) {
        case "Complex":
            seg = new ComplexSeg(dictionary);
            break;
        case "Simple":
            seg = new SimpleSeg(dictionary);
            break;
        case "MaxWord":
            seg = new MaxWordSeg(dictionary);
            break;
        default:
            throw new IllegalArgumentException();
        }

        MMSeg mmSeg = new MMSeg(new StringReader(""), seg);
        return mmSeg;
    }

}
