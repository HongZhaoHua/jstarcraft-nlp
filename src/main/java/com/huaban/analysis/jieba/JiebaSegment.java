package com.huaban.analysis.jieba;

public class JiebaSegment extends DictSegment {

    public JiebaSegment() {
        super((char) 0);
    }

    @Override
    public Hit match(char[] charArray) {
        return super.match(charArray, 0, charArray.length, null);
    }

    public void enableSegment(char[] charArray) {
        super.fillSegment(charArray);
    }

    @Override
    public void disableSegment(char[] charArray) {
        super.disableSegment(charArray);
    }

}
