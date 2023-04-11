package com.jstarcraft.nlp.algorithm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        BinaryTermFrequencyTestCase.class,

        CountTermFrequencyTestCase.class,

        LogarithmTermFrequencyTestCase.class,

        NaturalTermFrequencyTestCase.class,

        NormalizationTermFrequencyTestCase.class })
public class TermFrequencyTestSuite {

}
