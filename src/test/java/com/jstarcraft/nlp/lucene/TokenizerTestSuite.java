package com.jstarcraft.nlp.lucene;

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

        MmsegTokenizerTestCase.class,

        MynlpTokenizerTestCase.class,

        WordTokenizerTestCase.class,

})
public class TokenizerTestSuite {

}
