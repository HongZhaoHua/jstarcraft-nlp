package com.jstarcraft.nlp.dictionary.jieba;


import com.huaban.analysis.jieba.Hit;
import com.huaban.analysis.jieba.JiebaSegment;
import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * jieba词典
 * https://github.com/huaban/jieba-analysis/blob/092dbedb1fbe0cf2172f8e10707f8b52764bda31/src/test/java/com/huaban/analysis/jieba/JiebaSegmenterTest.java
 * 
 * @author Birdy
 *
 */
public class JiebaDictionary implements NlpDictionary {

    private JiebaSegment segment;

    public JiebaDictionary(JiebaSegment segment) {
        this.segment = segment;
    }

    @Override
    public boolean contain(String text) {
        Hit hit = segment.match(text.toCharArray());
        return hit.isMatch();
    }

}
