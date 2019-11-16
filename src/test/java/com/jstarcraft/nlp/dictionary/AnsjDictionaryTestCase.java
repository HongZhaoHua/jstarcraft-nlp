package com.jstarcraft.nlp.dictionary;

import org.nlpcn.commons.lang.tire.domain.SmartForest;

import com.jstarcraft.nlp.dictionary.ansj.AnsjDictionary;

public class AnsjDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary() {
        SmartForest<Boolean> forest = new SmartForest<Boolean>();
        forest.add("中华", true);
        forest.add("中华人民共和国", true);
        AnsjDictionary dictionary = new AnsjDictionary(forest);
        return dictionary;
    }

}
