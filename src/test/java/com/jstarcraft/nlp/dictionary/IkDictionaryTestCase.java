package com.jstarcraft.nlp.dictionary;

import org.wltea.analyzer.dic.IkSegment;

import com.jstarcraft.nlp.dictionary.ik.IkDictionary;

public class IkDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        IkSegment segment = new IkSegment();
        for (String text : texts) {
            segment.enableSegment(text.toCharArray());
        }
        IkDictionary dictionary = new IkDictionary(segment);
        return dictionary;
    }

}
