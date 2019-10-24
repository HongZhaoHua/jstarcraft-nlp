package com.jstarcraft.nlp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        AnsjTokenizerTestCase.class,

        CoreNlpTokenizerTestCase.class,

        HanlpTokenizerTestCase.class,

        IkTokenizerTestCase.class,

        JcsegTokenizerTestCase.class,

        JiebaTokenizerTestCase.class,

        LuceneTokenizerTestCase.class,

        MmsegTokenizerTestCase.class,

        MynlpTokenizerTestCase.class,

        ThulacTokenizerTestCase.class,

        WordTokenizerTestCase.class,

})
public class TokenizerTestSuite {

}
