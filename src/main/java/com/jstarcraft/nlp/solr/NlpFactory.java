package com.jstarcraft.nlp.solr;

import java.util.Map;

/**
 * NLP工厂
 * 
 * @author Birdy
 *
 * @param <T>
 */
public interface NlpFactory<T> {

    T build(Map<String, String> configurations);

}
