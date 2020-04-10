package com.jstarcraft.nlp.dictionary;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public abstract class NlpDictionaryTestCase {

    protected abstract NlpDictionary getDictionary(String... texts);

    @Test
    public void testContain() throws Exception {
        NlpDictionary dictionary = getDictionary("中华", "中华人民共和国", "自然", "自然界");
        Assert.assertTrue(dictionary.contain("中华"));
        Assert.assertFalse(dictionary.contain("中华人民"));
        Assert.assertTrue(dictionary.contain("中华人民共和国"));
        Assert.assertTrue(dictionary.contain("自然"));
        Assert.assertFalse(dictionary.contain("自然人"));
        Assert.assertTrue(dictionary.contain("自然界"));
        Assert.assertFalse(dictionary.contain("人民"));
    }

}
