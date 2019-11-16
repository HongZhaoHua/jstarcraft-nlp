package com.jstarcraft.nlp.dictionary;

import org.nlpcn.commons.lang.tire.domain.SmartForest;

import com.jstarcraft.nlp.dictionary.ansj.AnsjDictionary;

public class AnsjDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        SmartForest<Boolean> forest = new SmartForest<Boolean>();
        for (String text : texts) {
            forest.add(text, true);
        }
        AnsjDictionary dictionary = new AnsjDictionary(forest);
        return dictionary;
    }

}
