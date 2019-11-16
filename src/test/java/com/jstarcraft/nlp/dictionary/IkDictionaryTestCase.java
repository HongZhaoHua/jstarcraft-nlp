package com.jstarcraft.nlp.dictionary;

import org.wltea.analyzer.dic.IkSegment;

import com.jstarcraft.nlp.dictionary.ik.IkDictionary;

public class IkDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary() {
        IkSegment segment = new IkSegment();
        segment.enableSegment("中华".toCharArray());
        segment.enableSegment("中华人民共和国".toCharArray());
        IkDictionary dictionary = new IkDictionary(segment);
        return dictionary;
    }

}
