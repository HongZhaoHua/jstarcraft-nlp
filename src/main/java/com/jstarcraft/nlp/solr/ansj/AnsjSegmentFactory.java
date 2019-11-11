package com.jstarcraft.nlp.solr.ansj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.ansj.library.AmbiguityLibrary;
import org.ansj.library.CrfLibrary;
import org.ansj.library.DicLibrary;
import org.ansj.library.StopLibrary;
import org.ansj.library.SynonymsLibrary;
import org.ansj.recognition.Recognition;
import org.ansj.recognition.impl.BookRecognition;
import org.ansj.recognition.impl.EmailRecognition;
import org.ansj.recognition.impl.IDCardRecognition;
import org.ansj.recognition.impl.KilobitRecognition;
import org.ansj.recognition.impl.NatureRecognition;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.recognition.impl.SynonymsRecgnition;
import org.ansj.recognition.impl.TimeRecognition;
import org.ansj.recognition.impl.URLRecognition;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.ansj.AnsjTokenizer;

/**
 * Ansj工厂
 * 
 * <pre>
 * Ansj配置说明
 * https://github.com/NLPchina/ansj_seg/wiki/%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E8%AF%B4%E6%98%8E
 * </pre>
 * 
 * @author Birdy
 *
 */
public class AnsjSegmentFactory extends NlpSegmentFactory<Analysis> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnsjSegmentFactory.class);

    // Ansj分词方式的区别
    // https://github.com/NLPchina/ansj_seg/wiki/%E5%88%86%E8%AF%8D%E6%96%B9%E5%BC%8F
    static enum AnsjType {
        Base, Dictionary, Index, Nlp, Query;
    }

    public AnsjSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        Analysis analysis = build(configurations);

        String configuration = null;
        // 识别器
        List<Recognition> recognitions = new LinkedList<>();
        for (String proprety : new ArrayList<>(configurations.keySet())) {
            switch (proprety) {
            case "isBookRecognition":
                // 书籍识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        BookRecognition recognition = new BookRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            case "isEmailRecognition":
                // Email识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        EmailRecognition recognition = new EmailRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            case "isIdCardRecognition":
                // 身份证识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        IDCardRecognition recognition = new IDCardRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            case "isKilobitRecognition":
                // 千位识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        KilobitRecognition recognition = new KilobitRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            case "isNatureRecognition":
                // 词性识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        NatureRecognition recognition = new NatureRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            case "isStopRecognition":
                // 停用词识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    configuration = get(configurations, StopLibrary.DEFAULT);
                    if (StringUtil.isNotBlank(configuration)) {
                        String[] keys = configuration.split(",");
                        for (String key : keys) {
                            StopRecognition recognition = StopLibrary.get(key.trim());
                            if (recognition != null) {
                                recognitions.add(recognition);
                            }
                        }
                    }
                }
                break;
            case "isSynonymRecognition":
                // 同义词识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    configuration = get(configurations, SynonymsLibrary.DEFAULT);
                    if (StringUtil.isNotBlank(configuration)) {
                        String[] keys = configuration.split(",");
                        recognitions = new ArrayList<>(keys.length);
                        for (String key : keys) {
                            SynonymsRecgnition recognition = new SynonymsRecgnition(SynonymsLibrary.get(key.trim()));
                            if (recognition != null) {
                                recognitions.add(recognition);
                            }
                        }
                    }
                }
                break;
            case "isTimeRecognition":
                // 时间识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        TimeRecognition recognition = new TimeRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            case "isURLRecognition":
                // URL识别
                configuration = get(configurations, proprety);
                if (StringUtil.isNotBlank(configuration)) {
                    if (Boolean.valueOf(configuration)) {
                        URLRecognition recognition = new URLRecognition();
                        recognitions.add(recognition);
                    }
                }
                break;
            }
        }

        AnsjTokenizer tokenizer = new AnsjTokenizer(analysis, recognitions);
        return tokenizer;
    }

    @Override
    public Analysis build(Map<String, String> configurations) {
        Analysis analysis = null;
        String configuration = get(configurations, "ansjType", AnsjType.Base.name());
        switch (AnsjType.valueOf(configuration)) {
        case Base:
            analysis = new BaseAnalysis();
            break;
        case Dictionary:
            analysis = new DicAnalysis();
            break;
        case Index:
            analysis = new IndexAnalysis();
            break;
        case Nlp:
            NlpAnalysis nlp = new NlpAnalysis();
            configuration = get(configurations, CrfLibrary.DEFAULT);
            if (StringUtil.isNotBlank(configuration)) {
                // 自定义CRF模型
                // https://github.com/NLPchina/ansj_seg/wiki/%E5%AE%9A%E5%88%B6%E4%BD%A0%E8%87%AA%E5%B7%B1%E7%9A%84CRF%E6%A8%A1%E5%9E%8B
                nlp.setCrfModel(CrfLibrary.get(configuration));
            }
            analysis = nlp;
            break;
        case Query:
            analysis = new ToAnalysis();
            break;
        default:
            throw new IllegalArgumentException();
        }

        configuration = get(configurations, DicLibrary.DEFAULT);
        if (StringUtil.isNotBlank(configuration)) {
            String[] keys = configuration.split(",");
            Forest[] forests = new Forest[keys.length];
            for (int index = 0; index < forests.length; index++) {
                if (StringUtil.isBlank(keys[index])) {
                    continue;
                }
                forests[index] = DicLibrary.get(keys[index].trim());
            }
            analysis.setForests(forests);
        }

        // 自定义多义词
        configuration = get(configurations, AmbiguityLibrary.DEFAULT);
        if (StringUtil.isNotBlank(configuration)) {
            Forest ambiguity = AmbiguityLibrary.get(configuration.trim());
            analysis.setAmbiguityForest(ambiguity);
        }

        // 是否识别名称
        configuration = get(configurations, "isNameRecognition");
        if (StringUtil.isNotBlank(configuration)) {
            analysis.setIsNameRecognition(Boolean.valueOf(configuration));
        }

        // 是否识别数词
        configuration = get(configurations, "isNumRecognition");
        if (StringUtil.isNotBlank(configuration)) {
            analysis.setIsNumRecognition(Boolean.valueOf(configuration));

            // 是否识别量词
            configuration = get(configurations, "isQuantifierRecognition");
            if (StringUtil.isNotBlank(configuration)) {
                analysis.setIsQuantifierRecognition(Boolean.valueOf(configuration));
            }
        }

        // 是否保留字符
        configuration = get(configurations, "isRealName");
        if (StringUtil.isNotBlank(configuration)) {
            analysis.setIsRealName(Boolean.valueOf(configuration));
        }

        return analysis;
    }

}
