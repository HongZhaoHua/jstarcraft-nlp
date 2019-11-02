package com.jstarcraft.nlp.tokenization;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        AnsjIteratorTestCase.class,

        CoreNlpIteratorTestCase.class,

        HanlpIteratorTestCase.class,

        IkIteratorTestCase.class,

        JcsegIteratorTestCase.class,

        JiebaIteratorTestCase.class,

        LuceneIteratorTestCase.class,

        MmsegIteratorTestCase.class,

        MynlpIteratorTestCase.class,

        ThulacIteratorTestCase.class,

        WordIteratorTestCase.class,

})
public class NlpIteratorTestSuite {

}
