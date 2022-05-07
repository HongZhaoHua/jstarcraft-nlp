package com.jstarcraft.nlp.locale.phone;

import com.jstarcraft.nlp.locale.NlpAddress;

/**
 * 手机地址
 * 
 * @author Birdy
 *
 */
public interface PhoneAddress extends NlpAddress {

    /**
     * 获取手机号码
     * 
     * @return
     */
    public String getPhoneNumber();

}
