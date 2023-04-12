package com.jstarcraft.nlp.lucene.hanlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
import org.springframework.core.convert.converter.Converter;

import com.hankcs.hanlp.dictionary.py.Pinyin;

public class HanlpPinyinTokenFilterFactory extends TokenFilterFactory {

    private boolean original;

    private boolean first;

    private boolean full;

    /**
     * 初始化工厂类
     *
     * @param configuration 通过这个Map保存xml中的配置项
     */
    public HanlpPinyinTokenFilterFactory(Map<String, String> configuration) {
        super(configuration);
        original = getBoolean(configuration, "original", true);
        first = getBoolean(configuration, "first", true);
        full = getBoolean(configuration, "full", true);
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
        return new HanlpPinyinTokenFilter(input, original, converters);
    }

}
