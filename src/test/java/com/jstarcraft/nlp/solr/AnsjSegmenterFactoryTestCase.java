package com.jstarcraft.nlp.solr;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.jstarcraft.nlp.solr.ansj.AnsjSegmentFactory;

public class AnsjSegmenterFactoryTestCase extends NlpSegmenterFactoryTestCase {

    @Override
    protected NlpSegmentFactory getSegmenterFactory() {
        try {
            Properties keyValues = new Properties();
            keyValues.load(this.getClass().getResourceAsStream("ansj.properties"));
            Map<String, String> configurations = new LinkedHashMap<>();
            for (Entry<Object, Object> keyValue : keyValues.entrySet()) {
                String key = String.valueOf(keyValue.getKey());
                String value = String.valueOf(keyValue.getValue());
                configurations.put(key, value);
            }
            AnsjSegmentFactory factory = new AnsjSegmentFactory(configurations);
            return factory;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

}
