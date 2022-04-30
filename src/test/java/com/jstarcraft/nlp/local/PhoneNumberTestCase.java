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
        assertEquals("PhoneNumber [number=13006150000, province=湖北, city=武汉, areaCode=027, zipCode=430000, phoneType=联通]", phone.toString());

        phone = extractor.lookup("13308050000");
        assertEquals("PhoneNumber [number=13308050000, province=四川, city=成都, areaCode=028, zipCode=610000, phoneType=电信]", phone.toString());

        phone = extractor.lookup("13796000000");
        assertEquals("PhoneNumber [number=13796000000, province=黑龙江, city=哈尔滨, areaCode=0451, zipCode=150000, phoneType=移动]", phone.toString());

        phone = extractor.lookup("12345678901");
        assertNull(phone);

        phone = extractor.lookup("99999999999");
        assertNull(phone);

        phone = extractor.lookup("abcdefghijk");
        assertNull(phone);
    }

}