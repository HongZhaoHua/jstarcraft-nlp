package com.jstarcraft.nlp.lucene;

import java.text.BreakIterator;
import java.util.Iterator;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.util.SegmentingTokenizerBase;
import org.apache.lucene.util.AttributeFactory;

import com.jstarcraft.nlp.tokenization.NlpIterator;
import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * Lucene分词器
 * 
 * <pre>
 * 基于语句
 * </pre>
 * 
 * @author Birdy
 *
 */
public class LuceneTokenizer extends SegmentingTokenizerBase {

    /** 词元 **/
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    /** 位移 **/
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);
    /** 分词器 */
    private final NlpIterator<? extends NlpToken> tokenizer;
    /** 迭代器 */
    private Iterator<? extends NlpToken> iterator;

    private int count;

    private int length;

    public LuceneTokenizer(BreakIterator iterator, NlpIterator<? extends NlpToken> tokenizer) {
        super(iterator);
        this.tokenizer = tokenizer;
    }

    public LuceneTokenizer(AttributeFactory factory, BreakIterator iterator, NlpIterator<? extends NlpToken> tokenizer) {
        super(factory, iterator);
        this.tokenizer = tokenizer;
    }

    @Override
    protected void setNextSentence(int sentenceBegin, int sentenceEnd) {
        String text = new String(buffer, sentenceBegin, sentenceEnd - sentenceBegin);
        iterator = tokenizer.tokenize(text).iterator();
        length = text.length();
    }

    @Override
    protected boolean incrementWord() {
        if (!iterator.hasNext()) {
            count += length;
            return false;
        } else {
            clearAttributes();
            NlpToken token = iterator.next();
            termAttribute.append(token.getTerm());
            offsetAttribute.setOffset(correctOffset(count + token.getBegin()), correctOffset(count + token.getEnd()));
            return true;
        }
    }

}
