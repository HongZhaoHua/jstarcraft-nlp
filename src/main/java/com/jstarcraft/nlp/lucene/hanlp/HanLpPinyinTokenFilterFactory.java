package com.jstarcraft.nlp.lucene.hanlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
import org.springframework.core.convert.converter.Converter;

import com.hankcs.hanlp.dictionary.py.Pinyin;

public class HanLpPinyinTokenFilterFactory extends TokenFilterFactory {

    private boolean original;

    private boolean full;

    private boolean first;

    /**
     * 初始化工厂类
     *
     * @param args 通过这个Map保存xml中的配置项
     */
    public HanLpPinyinTokenFilterFactory(Map<String, String> args) {
        super(args);
        original = getBoolean(args, "original", true);
        full = getBoolean(args, "full", true);
        first = getBoolean(args, "first", true);
    }

    @Override
    public TokenStream create(TokenStream input) {
        List<Converter<List<Pinyin>, CharSequence>> converters = new ArrayList<>(5);
        if (first) {
            converters.add(new FirstPinyinConverter());
        }
        if (full) {
            converters.add(new FullPinyinConverter());
        }
        return new HanLpPinyinTokenFilter(input, original, converters);
    }

}
