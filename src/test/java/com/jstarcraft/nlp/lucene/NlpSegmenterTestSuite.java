package com.jstarcraft.nlp.lucene;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        AnsjSegmenterTestCase.class,

        CoreNlpSegmenterTestCase.class,

        HanlpSegmenterTestCase.class,

        IkSegmenterTestCase.class,

        JcsegSegmenterTestCase.class,

        JiebaSegmenterTestCase.class,

        MmsegSegmenterTestCase.class,

        MynlpSegmenterTestCase.class,

        WordSegmenterTestCase.class,

})
public class NlpSegmenterTestSuite {

}
