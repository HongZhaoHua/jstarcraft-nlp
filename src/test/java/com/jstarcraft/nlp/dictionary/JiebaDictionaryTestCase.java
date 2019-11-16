package com.jstarcraft.nlp.dictionary;

import com.huaban.analysis.jieba.JiebaSegment;
import com.jstarcraft.nlp.dictionary.jieba.JiebaDictionary;

public class JiebaDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        JiebaSegment segment = new JiebaSegment();
        for (String text : texts) {
            segment.enableSegment(text.toCharArray());
        }
        JiebaDictionary dictionary = new JiebaDictionary(segment);
        return dictionary;
    }

}
