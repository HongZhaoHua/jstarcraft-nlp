package com.jstarcraft.nlp.tokenization.lucene;

import java.util.Iterator;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import com.jstarcraft.nlp.tokenization.NlpToken;

public class LuceneToken implements Iterable<LuceneToken>, Iterator<LuceneToken>, NlpToken {

    private TokenStream stream;

    private CharTermAttribute term;
    // 偏移
    private OffsetAttribute offset;

    private String word;

    private int begin;

    private int end;

    private boolean flag;

    public LuceneToken(TokenStream stream) {
        this.stream = stream;
        this.term = stream.getAttribute(CharTermAttribute.class);
        this.offset = stream.getAttribute(OffsetAttribute.class);
        try {
            this.flag = this.stream.incrementToken();
            if (!flag) {
                this.stream.close();
            }
        } catch (Exception exception) {
            try {
                this.stream.close();
            } catch (Exception throwable) {
            }
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Iterator<LuceneToken> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return flag;
    }

    @Override
    public LuceneToken next() {
        try {
            word = term.toString();
            begin = offset.startOffset();
            end = offset.endOffset();
            flag = stream.incrementToken();
            if (!flag) {
                this.stream.close();
            }
        } catch (Exception exception) {
            try {
                this.stream.close();
            } catch (Exception throwable) {
            }
            throw new RuntimeException(exception);
        }
        return this;
    }

    @Override
    public String getTerm() {
        return word;
    }

    @Override
    public int getBegin() {
        return begin;
    }

    @Override
    public int getEnd() {
        return end;
    }

}
