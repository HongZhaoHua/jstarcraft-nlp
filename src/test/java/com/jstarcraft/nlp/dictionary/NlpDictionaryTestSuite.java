package com.jstarcraft.nlp.dictionary;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        AnsjDictionaryTestCase.class,

        CoreNlpDictionaryTestCase.class,

        HanLpDictionaryTestCase.class,

        IkDictionaryTestCase.class,

        JcsegDictionaryTestCase.class,

        JiebaDictionaryTestCase.class,

        MmsegDictionaryTestCase.class,

        MynlpDictionaryTestCase.class,

        ThulacDictionaryTestCase.class,

        WordDictionaryTestCase.class,

})
public class NlpDictionaryTestSuite {

}
