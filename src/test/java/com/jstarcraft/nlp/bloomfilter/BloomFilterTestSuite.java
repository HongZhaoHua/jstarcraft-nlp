package com.jstarcraft.nlp.bloomfilter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.jstarcraft.nlp.bloomfilter.bit.BitMapTestCase;

@RunWith(Suite.class)
@SuiteClasses({

        BitMapTestCase.class,

        GlobalBloomFilterTestCase.class,

        IntegerBloomFilterTestCase.class,

        LongBloomFilterTestCase.class,

})
public class BloomFilterTestSuite {

}
