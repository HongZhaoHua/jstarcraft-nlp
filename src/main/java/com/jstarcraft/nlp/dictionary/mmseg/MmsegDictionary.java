package com.jstarcraft.nlp.dictionary.mmseg;

import com.chenlb.mmseg4j.Dictionary;
import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * https://github.com/chenlb/mmseg4j-core/blob/db3d304c717d3cd0ed1e86117c785d46167103c1/src/test/java/com/chenlb/mmseg4j/MyTest.java
 * 
 * @author Birdy
 *
 */
public class MmsegDictionary implements NlpDictionary {

    private Dictionary dictionary;

    public MmsegDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean contain(String text) {
        return dictionary.match(text);
    }

}
