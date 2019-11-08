package com.jstarcraft.nlp.tokenization;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        AnsjTokenizerTestCase.class,

        CoreNlpTokenizerTestCase.class,

        HanLpTokenizerTestCase.class,

        IkTokenizerTestCase.class,

        JcsegTokenizerTestCase.class,

        JiebaTokenizerTestCase.class,

        LuceneTokenizerTestCase.class,

        MmsegTokenizerTestCase.class,

        MynlpTokenizerTestCase.class,

        ThulacTokenizerTestCase.class,

        WordTokenizerTestCase.class,

})
public class NlpTokenizerTestSuite {

}
