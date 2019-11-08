package com.jstarcraft.nlp.lucene.hanlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class HanLpPinyinTokenFilterFactory extends TokenFilterFactory {

    private boolean original;
    private boolean pinyin;
    private boolean pinyinFirstChar;

    /**
     * 初始化工厂类
     *
     * @param args 通过这个Map保存xml中的配置项
     */
    public HanLpPinyinTokenFilterFactory(Map<String, String> args) {
        super(args);
        original = getBoolean(args, "original", true);
        pinyin = getBoolean(args, "pinyin", true);
        pinyinFirstChar = getBoolean(args, "pinyinFirstChar", true);
    }

    @Override
    public TokenStream create(TokenStream input) {
        List<HanLpPinyinConverter> converters = new ArrayList<>();
        if (pinyin) {
            converters.add(new HanLpPinyinConverter.ToPinyinString());
        }
        if (pinyinFirstChar) {
            converters.add(new HanLpPinyinConverter.ToPinyinFirstCharString());
        }
        return new HanLpPinyinTokenFilter(input, original, converters);
    }

}
