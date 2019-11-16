package com.jstarcraft.nlp.dictionary;

import org.lionsoul.jcseg.tokenizer.Dictionary;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.ILexicon;
import org.lionsoul.jcseg.tokenizer.core.IWord;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;

import com.jstarcraft.nlp.dictionary.jcseg.JcsegDictionary;

public class JcsegDictionaryTestCase extends NlpDictionaryTestCase {

    @Override
    protected NlpDictionary getDictionary(String... texts) {
        ADictionary aDictionary = new Dictionary(new JcsegTaskConfig(false), true);
        for (String text : texts) {
            aDictionary.add(ILexicon.CJK_WORD, text, IWord.T_CJK_WORD);
        }
        JcsegDictionary dictionary = new JcsegDictionary(aDictionary);
        return dictionary;
    }

}
