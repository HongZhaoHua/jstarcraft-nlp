package com.jstarcraft.nlp.dictionary.ik;

import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.Hit;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * https://tool.oschina.net/uploads/apidocs/ikanalyzer/org/wltea/analyzer/dic/Dictionary.html
 * 
 * @author Birdy
 *
 */
public class IkDictionary implements NlpDictionary {

    private Dictionary dictionary;

    public IkDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean contain(String text) {
        Hit hit = dictionary.matchInMainDict(text.toCharArray());
        return hit.isMatch();
    }

}
