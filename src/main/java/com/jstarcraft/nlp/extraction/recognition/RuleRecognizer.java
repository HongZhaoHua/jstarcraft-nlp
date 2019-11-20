package com.jstarcraft.nlp.extraction.recognition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jstarcraft.nlp.tokenization.NlpToken;

/**
 * 基于规则识别器
 * 
 * @author Birdy
 *
 */
public class RuleRecognizer implements NlpRecognizer {

    private Pattern pattern;

    public RuleRecognizer(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean recognize(NlpToken token) {
        Matcher matcher = pattern.matcher(token.getTerm());
        return matcher.matches();
    }

}
