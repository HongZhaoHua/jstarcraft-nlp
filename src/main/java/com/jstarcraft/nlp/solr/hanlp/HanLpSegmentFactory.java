package com.jstarcraft.nlp.solr.hanlp;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.TraditionalChineseTokenizer;
import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.hanlp.HanLpTokenizer;

/**
 * HanLP工厂
 * 
 * <pre>
 * HanLP配置说明
 * https://github.com/hankcs/hanlp-lucene-plugin/blob/master/README.md#%E9%AB%98%E7%BA%A7%E9%85%8D%E7%BD%AE
 * </pre>
 * 
 * @author Birdy
 *
 */
public class HanLpSegmentFactory extends NlpSegmentFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(HanLpSegmentFactory.class);

    public HanLpSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        String algorithm = get(configurations, "algorithm", "viterbi");
        Segment segment = HanLP.newSegment(algorithm);

        // 设置模式
        segment.enableIndexMode(getBoolean(configurations, "enableIndexMode", false));

        segment.enableOffset(true);

        // 是否识别数词和量词
        segment.enableNumberQuantifierRecognize(getBoolean(configurations, "enableNumberQuantifierRecognize", false));

        // 是否识别人名
        segment.enableNameRecognize(getBoolean(configurations, "enableNameRecognize", false));

        // 是否识别音译名
        // TODO 考虑是否依赖enableNameRecognize
        segment.enableTranslatedNameRecognize(getBoolean(configurations, "enableTranslatedNameRecognize", false));

        // 是否识别日本名?
        // TODO 考虑是否依赖enableNameRecognize
        segment.enableJapaneseNameRecognize(getBoolean(configurations, "enableJapaneseNameRecognize", false));

        // 是否识别组织名
        segment.enableOrganizationRecognize(getBoolean(configurations, "enableOrganizationRecognize", false));

        // 是否识别地名
        segment.enablePlaceRecognize(getBoolean(configurations, "enablePlaceRecognize", false));

        // 是否执行字符正规化(繁体->简体,全角->半角,大写->小写)
        HanLP.Config.Normalization = getBoolean(configurations, "enableNormalization", HanLP.Config.Normalization);

        // 自定义字典
        segment.enableCustomDictionary(getBoolean(configurations, "enableCustomDictionary", false));
        segment.enableCustomDictionaryForcing(getBoolean(configurations, "enableCustomDictionaryForcing", false));
        Set<String> customDictionaryPaths = getSet(configurations, "customDictionaryPath");
        if (customDictionaryPaths != null) {
            HanLP.Config.CustomDictionaryPath = customDictionaryPaths.toArray(new String[customDictionaryPaths.size()]);
        }

        // 自定义停用词
        // TODO 暂时不支持
        String stopWordDictionaryPath = get(configurations, "stopWordDictionaryPath");
        if (stopWordDictionaryPath != null) {
            TreeSet<String> stopWordDictionary = new TreeSet<>();
            stopWordDictionary.addAll(IOUtil.readLineListWithLessMemory(stopWordDictionaryPath));
        }

        // 是否使用调试
        if (getBoolean(configurations, "enableDebug", false)) {
            HanLP.Config.enableDebug();
        }

        // 是否支持繁体
        boolean enableTraditionalChineseMode = getBoolean(configurations, "enableTraditionalChineseMode", false);
        if (enableTraditionalChineseMode) {
            segment.enableIndexMode(false);
            TraditionalChineseTokenizer.SEGMENT = segment;
            segment = new Segment() {

                @Override
                protected List<Term> segSentence(char[] sentence) {
                    List<Term> terms = TraditionalChineseTokenizer.segment(new String(sentence));
                    return terms;
                }

            };
        }

        HanLpTokenizer tokenizer = new HanLpTokenizer(segment);
        return tokenizer;
    }

}
