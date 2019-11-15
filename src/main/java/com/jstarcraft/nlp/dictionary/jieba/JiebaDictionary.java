package com.jstarcraft.nlp.dictionary.jieba;

import com.huaban.analysis.jieba.WordDictionary;
import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * https://github.com/huaban/jieba-analysis/blob/092dbedb1fbe0cf2172f8e10707f8b52764bda31/src/test/java/com/huaban/analysis/jieba/JiebaSegmenterTest.java
 * 
 * @author Birdy
 *
 */
public class JiebaDictionary implements NlpDictionary {

    private WordDictionary dictionary;

    public JiebaDictionary(WordDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean contain(String text) {
        return dictionary.containsWord(text);
    }

}
