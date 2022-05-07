package com.jstarcraft.nlp.locale.card;

import com.jstarcraft.nlp.locale.NlpAddress;

/**
 * 身份证地址
 * 
 * @author Birdy
 *
 */
public interface CardAddress extends NlpAddress {

    /**
     * 获取身份证号码
     * 
     * @return
     */
    public String getCardNumber();

}
