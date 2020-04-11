package com.jstarcraft.nlp.lucene.mynlp;

import java.io.IOException;
import java.util.Iterator;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mayabot.nlp.segment.AtomIterator;
import com.mayabot.nlp.segment.Lexer;
import com.mayabot.nlp.segment.LexerReader;
import com.mayabot.nlp.segment.Nature;
import com.mayabot.nlp.segment.OverlapIterator;
import com.mayabot.nlp.segment.WordTerm;
import com.mayabot.nlp.segment.WordTermIterableMode;

/**
 * MYNLP分词分词器
 * 
 * @author Birdy
 *
 */
public final class MynlpTokenizer extends Tokenizer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MynlpTokenizer.class);

    /** 词元 **/
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    /** 位移 **/
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);
    /** 距离 **/
    private final PositionIncrementAttribute positionAttribute = addAttribute(PositionIncrementAttribute.class);
    /** 词性 **/
    private final TypeAttribute typeAttribute = addAttribute(TypeAttribute.class);

    private WordTermIterableMode mode = WordTermIterableMode.TOP;

    public static Tokenizer fromLexer(LexerReader lexerReader) {
        return new MynlpTokenizer(lexerReader);
    }

    public static Tokenizer fromLexer(Lexer lexer) {
        return new MynlpTokenizer(lexer.reader());
    }

//    private final PositionLengthAttribute positionLenAttr = addAttribute(PositionLengthAttribute.class);

    private Iterator<WordTerm> iterator;

    private final LexerReader lexerReader;

    /**
     * Lucene Tokenizer的Mynlp插件实现
     *
     * @param lexerReader LexerReader
     */
    public MynlpTokenizer(LexerReader lexerReader) {
        this.lexerReader = lexerReader;
    }

    public MynlpTokenizer(LexerReader lexerReader, WordTermIterableMode mode) {
        this.lexerReader = lexerReader;
        this.mode = mode;
    }

    public WordTermIterableMode getMode() {
        return mode;
    }

    /**
     * 返回下一个Token
     *
     * @return 是否有Token
     */
    @Override
    public boolean incrementToken() {
        clearAttributes();

        if (iterator.hasNext()) {
            WordTerm next = iterator.next();

            if (Nature.w == next.getNature()) {
                typeAttribute.setType("Punctuation");
            }

            positionAttribute.setPositionIncrement(next.getPosInc());
            termAttribute.setEmpty().append(next.word);
            offsetAttribute.setOffset(next.offset, next.offset + next.length());

//            if (mode == IterableMode.GRAPH) {
//                if (next.hasSubword()) {
//                    positionLenAttr.setPositionLength(next.getSubword().size());
//                }else{
//                    positionLenAttr.setPositionLength(1);
//                }
//            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called by a consumer before it begins consumption using {@link #incrementToken()}.
     * <p>
     * Resets this stream to a clean state. Stateful implementations must implement this method so that they can be reused, just as if they had been created fresh.
     * <p>
     * If you override this method, always call {@code super.reset()}, otherwise some internal state will not be correctly reset (e.g., {@link Tokenizer} will throw {@link IllegalStateException} on further usage).
     */
    @Override
    public void reset() throws IOException {
        super.reset();

        switch (mode) {
        case Overlap:
            iterator = new OverlapIterator(lexerReader.scan(this.input).iterator());
            break;
        case ATOM:
            iterator = new AtomIterator(lexerReader.scan(this.input).iterator());
            break;
        case TOP:
        default:
            iterator = lexerReader.scan(this.input).iterator();
        }
    }

}
