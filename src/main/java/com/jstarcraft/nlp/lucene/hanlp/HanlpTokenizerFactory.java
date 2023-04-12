package com.jstarcraft.nlp.lucene.hanlp;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.TraditionalChineseTokenizer;

public class HanlpTokenizerFactory extends TokenizerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(HanlpTokenizerFactory.class);

    private boolean enableIndexMode;

    private boolean enableNumberQuantifierRecognize;

    private boolean enableCustomDictionary;

    private boolean enableCustomDictionaryForcing;

    private boolean enableTranslatedNameRecognize;

    private boolean enableJapaneseNameRecognize;

    private boolean enableOrganizationRecognize;

    private boolean enablePlaceRecognize;

    private boolean enableNameRecognize;

    private boolean enableTraditionalChineseMode;

    private String algorithm;

    private Set<String> stopWordDictionary;

    /**
     * 初始化工厂类
     *
     * @param configuration 通过这个Map保存xml中的配置项
     */
    public HanlpTokenizerFactory(Map<String, String> configuration) {
        super(configuration);
        enableIndexMode = getBoolean(configuration, "enableIndexMode", true);
        enableNumberQuantifierRecognize = getBoolean(configuration, "enableNumberQuantifierRecognize", false);
        enableCustomDictionary = getBoolean(configuration, "enableCustomDictionary", true);
        enableCustomDictionaryForcing = getBoolean(configuration, "enableCustomDictionaryForcing", true);
        enableTranslatedNameRecognize = getBoolean(configuration, "enableTranslatedNameRecognize", false);
        enableJapaneseNameRecognize = getBoolean(configuration, "enableJapaneseNameRecognize", false);
        enableOrganizationRecognize = getBoolean(configuration, "enableOrganizationRecognize", false);
        enableNameRecognize = getBoolean(configuration, "enableNameRecognize", false);
        enablePlaceRecognize = getBoolean(configuration, "enablePlaceRecognize", false);
        enableTraditionalChineseMode = getBoolean(configuration, "enableTraditionalChineseMode", false);
        HanLP.Config.Normalization = getBoolean(configuration, "enableNormalization", HanLP.Config.Normalization);
        algorithm = getString(configuration, "algorithm", "viterbi");
        Set<String> customDictionaryPathSet = getSet(configuration, "customDictionaryPath");
        if (customDictionaryPathSet != null) {
            HanLP.Config.CustomDictionaryPath = customDictionaryPathSet.toArray(new String[0]);
        }
        String stopWordDictionaryPath = get(configuration, "stopWordDictionaryPath");
        if (stopWordDictionaryPath != null) {
            stopWordDictionary = new TreeSet<>();
            stopWordDictionary.addAll(IOUtil.readLineListWithLessMemory(stopWordDictionaryPath));
        }
        if (getBoolean(configuration, "enableDebug", false)) {
            HanLP.Config.enableDebug();
        }
    }

    protected final String getString(Map<String, String> args, String name, String defaultVal) {
        String s = args.remove(name);
        return s == null ? defaultVal : s;
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        Segment segment = HanLP.newSegment(algorithm).enableOffset(true).enableIndexMode(enableIndexMode).enableNameRecognize(enableNameRecognize).enableNumberQuantifierRecognize(enableNumberQuantifierRecognize).enableCustomDictionary(enableCustomDictionary).enableCustomDictionaryForcing(enableCustomDictionaryForcing).enableTranslatedNameRecognize(enableTranslatedNameRecognize).enableJapaneseNameRecognize(enableJapaneseNameRecognize).enableOrganizationRecognize(enableOrganizationRecognize)
                .enablePlaceRecognize(enablePlaceRecognize);
        if (enableTraditionalChineseMode) {
            segment.enableIndexMode(false);
            Segment inner = segment;
            TraditionalChineseTokenizer.SEGMENT = inner;
            segment = new Segment() {
                @Override
                protected List<Term> segSentence(char[] sentence) {
                    List<Term> termList = TraditionalChineseTokenizer.segment(new String(sentence));
                    return termList;
                }
            };
        }

        return new HanlpTokenizer(segment, stopWordDictionary);
    }

}
