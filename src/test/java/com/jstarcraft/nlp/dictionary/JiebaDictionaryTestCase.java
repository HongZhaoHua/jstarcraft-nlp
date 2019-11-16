package com.jstarcraft.nlp.dictionary;

import com.huaban.analysis.jieba.JiebaSegment;
import com.jstarcraft.nlp.dictionary.jieba.JiebaDictionary;

public class JiebaDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary() {
        JiebaSegment segment = new JiebaSegment();
        segment.enableSegment("中华".toCharArray());
        segment.enableSegment("中华人民共和国".toCharArray());
        JiebaDictionary dictionary = new JiebaDictionary(segment);
        return dictionary;
    }

}
