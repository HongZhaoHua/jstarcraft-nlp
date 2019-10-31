package com.jstarcraft.nlp.lucene.hanlp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.utility.TextUtility;

public class HanlpTokenScanner extends Tokenizer {

    // 词元
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    // 位移
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);
    // 距离
    private final PositionIncrementAttribute positionAttribute = addAttribute(PositionIncrementAttribute.class);
    // 词性
    private final TypeAttribute typeAttribute = addAttribute(TypeAttribute.class);

    private SegmentWrapper segment;
    private BinTrie<String> filter;

    /**
     * 单文档当前所在的总offset,当reset(切换multi-value fields中的value)的时候不清零,在end(切换field)时清零
     */
    private int totalOffset = 0;

    /**
     * @param segment              HanLP中的某个分词器
     * @param filter               停用词
     * @param enablePorterStemming 英文原型转换
     */
    public HanlpTokenScanner(Segment segment, Set<String> filter) {
        super();
        this.segment = new SegmentWrapper(this.input, segment);
        if (filter != null && filter.size() > 0) {
            this.filter = new BinTrie<String>();
            for (String stopWord : filter) {
                this.filter.put(stopWord, null);
            }
        }
    }

    @Override
    final public boolean incrementToken() throws IOException {
        clearAttributes();
        int position = 0;
        Term term;
        boolean un_increased = true;
        do {
            term = segment.next();
            if (term == null) {
                break;
            }
            if (TextUtility.isBlank(term.word)) {
                // 过滤掉空白符,提高索引效率
                continue;
            }

            if (filter != null && filter.containsKey(term.word)) {
                continue;
            } else {
                ++position;
                un_increased = false;
            }
        } while (un_increased);

        if (term != null) {
            positionAttribute.setPositionIncrement(position);
            termAttribute.setEmpty().append(term.word);
            offsetAttribute.setOffset(correctOffset(totalOffset + term.offset), correctOffset(totalOffset + term.offset + term.word.length()));
            typeAttribute.setType(term.nature == null ? "null" : term.nature.toString());
            return true;
        } else {
            totalOffset += segment.offset;
            return false;
        }
    }

    @Override
    public void end() throws IOException {
        super.end();
        offsetAttribute.setOffset(totalOffset, totalOffset);
        totalOffset = 0;
    }

    /**
     * 必须重载的方法,否则在批量索引文件时将会导致文件索引失败
     */
    @Override
    public void reset() throws IOException {
        super.reset();
        segment.reset(new BufferedReader(input));
    }

}
