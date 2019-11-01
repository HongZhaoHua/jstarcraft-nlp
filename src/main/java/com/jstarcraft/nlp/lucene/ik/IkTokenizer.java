package com.jstarcraft.nlp.lucene.ik;

import java.io.IOException;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.AttributeFactory;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * IK分词器
 * 
 * @author Birdy
 *
 */
public final class IkTokenizer extends Tokenizer {

    /** 词元 **/
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    /** 位移 **/
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);
    /** 距离 **/
    private final PositionIncrementAttribute positionAttribute = addAttribute(PositionIncrementAttribute.class);
    /** 词性 **/
    private final TypeAttribute typeAttribute = addAttribute(TypeAttribute.class);

    // IK分词器实现
    private IKSegmenter _IKImplement;

    // 记录最后一个词元的结束位置
    private int endPosition;

    /**
     * Lucene 7.6 Tokenizer适配器类构造函数
     */
    public IkTokenizer() {
        this(false);
    }

    public IkTokenizer(boolean useSmart) {
        super();
        init(useSmart);
    }

    public IkTokenizer(AttributeFactory factory) {
        this(factory, false);
    }

    public IkTokenizer(AttributeFactory factory, boolean useSmart) {
        super(factory);
        init(useSmart);
    }

    private void init(boolean useSmart) {
        _IKImplement = new IKSegmenter(input, useSmart);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.lucene.analysis.TokenStream#incrementToken()
     */
    @Override
    public boolean incrementToken() throws IOException {
        // 清除所有的词元属性
        clearAttributes();
        Lexeme nextLexeme = _IKImplement.next();
        if (nextLexeme != null) {
            // 将Lexeme转成Attributes
            // 设置词元文本
            termAttribute.append(nextLexeme.getLexemeText());
            // 设置词元长度
            termAttribute.setLength(nextLexeme.getLength());
            // 设置词元位移
            offsetAttribute.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());
            // 记录分词的最后位置
            endPosition = nextLexeme.getEndPosition();
            // 记录词元分类
            typeAttribute.setType(nextLexeme.getLexemeTypeString());
            // 返会true告知还有下个词元
            return true;
        }
        // 返会false告知词元输出完毕
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.lucene.analysis.Tokenizer#reset(java.io.Reader)
     */
    @Override
    public void reset() throws IOException {
        super.reset();
        _IKImplement.reset(input);
    }

    @Override
    public final void end() {
        // set final offset
        int finalOffset = correctOffset(this.endPosition);
        offsetAttribute.setOffset(finalOffset, finalOffset);
    }

}
