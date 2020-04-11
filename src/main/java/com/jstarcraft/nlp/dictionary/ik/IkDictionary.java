package com.jstarcraft.nlp.dictionary.ik;

import org.wltea.analyzer.dic.Hit;
import org.wltea.analyzer.dic.IkSegment;

import com.jstarcraft.nlp.dictionary.NlpDictionary;

/**
 * IK词典
 * 
 * <pre>
 * https://tool.oschina.net/uploads/apidocs/ikanalyzer/org/wltea/analyzer/dic/Dictionary.html
 * </pre>
 * 
 * @author Birdy
 *
 */
public class IkDictionary implements NlpDictionary {

    private IkSegment segment;

    public IkDictionary(IkSegment segment) {
        this.segment = segment;
    }

    @Override
    public boolean contain(String text) {
        Hit hit = segment.match(text.toCharArray());
        return hit.isMatch();
    }

}
