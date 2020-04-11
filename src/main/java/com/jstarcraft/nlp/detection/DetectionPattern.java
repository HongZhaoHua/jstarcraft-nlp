package com.jstarcraft.nlp.detection;

import java.util.regex.Pattern;

/**
 * 检测规则
 * 
 * @author Birdy
 *
 */
public class DetectionPattern {

    private String name;

    private Pattern pattern;

    DetectionPattern(String name, Pattern pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern() {
        return pattern;
    }

}
