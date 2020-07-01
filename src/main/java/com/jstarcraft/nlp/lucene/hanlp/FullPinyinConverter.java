package com.jstarcraft.nlp.lucene.hanlp;

import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.hankcs.hanlp.dictionary.py.Pinyin;

/**
 * 全拼转换器
 * 
 * @author Birdy
 *
 */
public class FullPinyinConverter implements Converter<List<Pinyin>, CharSequence> {

    private StringBuilder buffer = new StringBuilder(64);

    @Override
    public CharSequence convert(List<Pinyin> pinyins) {
        buffer.setLength(0);
        for (Pinyin pinyin : pinyins) {
            if (pinyin != Pinyin.none5) {
                buffer.append(pinyin.getPinyinWithoutTone());
            }
        }
        return buffer;
    }

}
