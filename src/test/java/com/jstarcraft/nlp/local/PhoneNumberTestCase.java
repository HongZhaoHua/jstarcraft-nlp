package com.jstarcraft.nlp.local;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import com.jstarcraft.nlp.locale.phone.PhoneNumber;
import com.jstarcraft.nlp.locale.phone.PhoneNumberExtractor;

/**
 * 手机号码单元测试
 * 
 * @author Birdy
 *
 */
public class PhoneNumberTestCase {

    @Test
    public void testNormalCase() throws Exception {
        PhoneNumberExtractor extractor = new PhoneNumberExtractor();

        PhoneNumber phone = extractor.lookup("13006150000");
        System.out.println(phone.toString());
        assertEquals("PhoneNumber [number=13006150000, province=湖北, city=武汉, areaCode=027, zipCode=430000, phoneType=联通]", phone.toString());

        phone = extractor.lookup("12345678901");
        assertNull(phone);

        phone = extractor.lookup("99999999999");
        assertNull(phone);

        phone = extractor.lookup("abcdefghijk");
        assertNull(phone);
    }

}