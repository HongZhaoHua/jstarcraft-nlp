package com.jstarcraft.nlp.analysis.lexical.tag;

/**
 * NLP标注器
 * 
 * @author Birdy
 *
 */
public interface NlpTagger {

    NlpTag getTag(String nature);

}
