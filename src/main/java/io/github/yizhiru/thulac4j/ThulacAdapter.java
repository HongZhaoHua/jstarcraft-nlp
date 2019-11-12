package io.github.yizhiru.thulac4j;

import java.io.InputStream;

public class ThulacAdapter {

    public static final SPChineseTokenizer getThulac(InputStream weightStream, InputStream featureStream, InputStream labelStream) {
        SPChineseTokenizer thulac = new SPChineseTokenizer(weightStream, featureStream, labelStream);
        return thulac;
    }
    
}
