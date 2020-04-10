package com.jstarcraft.nlp.detection;

import java.util.regex.Pattern;

/**
 * 检测规则
 * 
 * @author Birdy
 *
 */
public class DetectionRegulation {

    private String name;

    private Pattern pattern;

    DetectionRegulation(String name, Pattern pattern) {
        this.name = name;
        this.pattern = pattern;
    }

}
