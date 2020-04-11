package com.jstarcraft.nlp.dictionary.ansj;

import org.nlpcn.commons.lang.tire.SmartGetWord;
import org.nlpcn.commons.lang.tire.domain.SmartForest;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * Ansj词典
 * 
 * <pre>
 * https://github.com/NLPchina/nlp-lang/blob/1665ffae0130dd6cd5a642bbeb0cca1056cd62e8/src/test/java/org/nlpcn/commons/lang/tire/splitWord/ForestTest.java
 * </pre>
 * 
 * @author Birdy
 *
 */
public class AnsjDictionary implements NlpDictionary {

    private SmartForest<?> forest;

    public AnsjDictionary(SmartForest<?> forest) {
        this.forest = forest;
    }

    @Override
    public boolean contain(String text) {
        SmartGetWord<?> word = forest.getWord(text);
        String string = word.getFrontWords();
        if (string == null) {
            return false;
        } else {
            return text.equals(string);
        }
    }

}
