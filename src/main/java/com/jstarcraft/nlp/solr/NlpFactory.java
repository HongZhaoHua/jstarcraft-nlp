package com.jstarcraft.nlp.solr;

import java.util.Map;

public interface NlpFactory<T> {

    T build(Map<String, String> configurations);
    
}
