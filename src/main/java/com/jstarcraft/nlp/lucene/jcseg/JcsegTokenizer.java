package com.jstarcraft.nlp.lucene.jcseg;

import java.io.IOException;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.ISegment;
import org.lionsoul.jcseg.tokenizer.core.IWord;
import org.lionsoul.jcseg.tokenizer.core.JcsegException;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.lionsoul.jcseg.tokenizer.core.SegmentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jcseg分词器
 * 
 * @author Birdy
 *
 */
public class JcsegTokenizer extends Tokenizer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JcsegTokenizer.class);

    /** 词元 **/
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    /** 位移 **/
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);
    /** 距离 **/
    private final PositionIncrementAttribute positionAttribute = addAttribute(PositionIncrementAttribute.class);
    /** 词性 **/
    private final TypeAttribute typeAttribute = addAttribute(TypeAttribute.class);

    // The default Jcseg segmentor
    private final ISegment segmentor;

    /**
     * field level offset tracker for multiple-value field like the Array field in
     * Elasticseach or Solr
     */
    private int fieldOffset = 0;

    public JcsegTokenizer(int mode, JcsegTaskConfig config, ADictionary dic) throws JcsegException, IOException {
        segmentor = SegmentFactory.createJcseg(mode, new Object[] { config, dic });
        segmentor.reset(input);
    }

    @Override
    final public boolean incrementToken() throws IOException {
        /* Clear the attributes */
        clearAttributes();

        final IWord word = segmentor.next();
        if (word == null) {
            fieldOffset = offsetAttribute.endOffset();
            return false;
        }

        // char[] token = word.getValue().toCharArray();
        // termAtt.copyBuffer(token, 0, token.length);
        termAttribute.setLength(0);
        termAttribute.append(word.getValue());
        offsetAttribute.setOffset(correctOffset(fieldOffset + word.getPosition()), correctOffset(fieldOffset + word.getPosition() + word.getLength()));
        typeAttribute.setType("word");

        return true;
    }

    @Override
    public void end() throws IOException {
        super.end();
        offsetAttribute.setOffset(correctOffset(fieldOffset), correctOffset(fieldOffset));
        fieldOffset = 0;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        segmentor.reset(input);
    }

}
