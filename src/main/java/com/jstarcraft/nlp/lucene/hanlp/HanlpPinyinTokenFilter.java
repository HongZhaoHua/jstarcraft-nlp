package com.jstarcraft.nlp.lucene.hanlp;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.springframework.core.convert.converter.Converter;

import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.dictionary.py.PinyinDictionary;

/**
 * 拼音TokenFilter
 */
public final class HanlpPinyinTokenFilter extends TokenFilter {

    // 词性
    private final TypeAttribute typeAttribute = addAttribute(TypeAttribute.class);
    // 当前词
    private final CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);
    // 是否保留原词
    private final boolean original;
    // 拼音转换器
    private final Collection<Converter<List<Pinyin>, CharSequence>> converters;
    // 待输出拼音队列
    private final Queue<CharSequence> queue;

    public HanlpPinyinTokenFilter(TokenStream input, boolean original, Converter<List<Pinyin>, CharSequence>... converters) {
        this(input, original, Arrays.asList(converters));
    }

    public HanlpPinyinTokenFilter(TokenStream input, boolean original, Collection<Converter<List<Pinyin>, CharSequence>> converters) {
        super(input);
        this.original = original;
        this.converters = converters;
        this.queue = new ArrayDeque<>(converters.size());
    }

    @Override
    public boolean incrementToken() throws IOException {
        while (true) {
            CharSequence term = queue.poll();
            if (term != null) {
                typeAttribute.setType("pinyin");
                charTermAttribute.setEmpty().append(term);
                return true;
            }
            if (input.incrementToken()) {
                String text = charTermAttribute.toString();
                List<Pinyin> pinyin = PinyinDictionary.convertToPinyin(text);
                for (Converter<List<Pinyin>, CharSequence> converter : converters) {
                    CharSequence pinyinTerm = converter.convert(pinyin);
                    if (pinyinTerm != null && pinyinTerm.length() > 0) {
                        queue.offer(pinyinTerm);
                    }
                }
                if (original) {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

}
