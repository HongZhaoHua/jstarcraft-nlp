package com.jstarcraft.nlp.tokenization.lucene;

import java.util.Iterator;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import com.jstarcraft.nlp.tokenization.Token;

public class LuceneToken implements Iterable<Token>, Iterator<Token>, Token {

    private TokenStream stream;

    private CharTermAttribute term;
    // 偏移量
    private OffsetAttribute offset;

    public LuceneToken(TokenStream stream) {
        this.stream = stream;
    }

    @Override
    public Iterator<Token> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        try {
            return stream.incrementToken();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Token next() {
        term = stream.getAttribute(CharTermAttribute.class);
        offset = stream.getAttribute(OffsetAttribute.class);
        return this;
    }

    @Override
    public String getTerm() {
        return term.toString();
    }

    @Override
    public int getBegin() {
        return offset.startOffset();
    }

    @Override
    public int getEnd() {
        return offset.endOffset();
    }

}
