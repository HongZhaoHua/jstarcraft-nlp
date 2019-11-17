package com.jstarcraft.nlp.dictionary.mmseg;

import com.chenlb.mmseg4j.CharNode;
import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * MMSEG词典
 * https://github.com/chenlb/mmseg4j-core/blob/db3d304c717d3cd0ed1e86117c785d46167103c1/src/test/java/com/chenlb/mmseg4j/MyTest.java
 * 
 * @author Birdy
 *
 */
public class MmsegDictionary implements NlpDictionary {

    private CharNode node;

    public MmsegDictionary(CharNode node) {
        this.node = node;
    }

    @Override
    public boolean contain(String text) {
        return node.indexOf(text.toCharArray(), -1, text.length()) > 0;
    }

}
