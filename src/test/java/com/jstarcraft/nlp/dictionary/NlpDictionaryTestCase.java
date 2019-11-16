package com.jstarcraft.nlp.dictionary;

import org.junit.Assert;
import org.junit.Test;

public abstract class NlpDictionaryTestCase {

    protected abstract NlpDictionary getDictionary();

    @Test
    public void testContain() throws Exception {
        NlpDictionary dictionary = getDictionary();
        System.out.println(dictionary.contain("中华"));
        System.out.println(dictionary.contain("中华人民"));
        System.out.println(dictionary.contain("中华人民共和国"));
        Assert.assertTrue(dictionary.contain("中华"));
        Assert.assertFalse(dictionary.contain("中华人民"));
        Assert.assertTrue(dictionary.contain("中华人民共和国"));
    }

}
