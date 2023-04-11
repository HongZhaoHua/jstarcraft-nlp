package com.jstarcraft.nlp.algorithm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

        MaximumInverseDocumentFrequencyTestCase.class,

        NaturalInverseDocumentFrequencyTestCase.class,

        ProbabilisticInverseDocumentFrequencyTestCase.class,

        SmoothInverseDocumentFrequencyTestCase.class,

        UnaryInverseDocumentFrequencyTestCase.class })
public class InverseDocumentFrequencyTestSuite {

}
