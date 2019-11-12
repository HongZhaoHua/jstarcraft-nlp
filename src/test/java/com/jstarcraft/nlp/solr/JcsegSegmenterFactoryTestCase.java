package com.jstarcraft.nlp.solr;

import java.util.LinkedHashMap;
import java.util.Map;

import com.jstarcraft.nlp.solr.jcseg.JcsegSegmentFactory;

public class JcsegSegmenterFactoryTestCase extends NlpSegmenterFactoryTestCase {

    @Override
    protected NlpSegmentFactory getSegmenterFactory() throws Exception {
        Map<String, String> configurations = new LinkedHashMap<>();
        configurations.put("mode", "nlp");
        JcsegSegmentFactory factory = new JcsegSegmentFactory(configurations);
        return factory;
    }

}
