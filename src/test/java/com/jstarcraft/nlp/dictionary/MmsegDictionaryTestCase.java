package com.jstarcraft.nlp.dictionary;

import com.chenlb.mmseg4j.CharNode;
import com.jstarcraft.nlp.dictionary.mmseg.MmsegDictionary;

public class MmsegDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        CharNode node = new CharNode();
        for (String text : texts) {
            node.addWordTail(text.toCharArray());
        }
        MmsegDictionary dictionary = new MmsegDictionary(node);
        return dictionary;
    }

}
