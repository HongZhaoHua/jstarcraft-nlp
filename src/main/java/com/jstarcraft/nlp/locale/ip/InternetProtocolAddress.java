package com.jstarcraft.nlp.locale.ip;

import com.jstarcraft.nlp.locale.NlpAddress;

/**
 * IP地址
 * 
 * @author Birdy
 *
 */
public interface InternetProtocolAddress extends NlpAddress {

    /**
     * 获取IP号码
     * 
     * @return
     */
    public String getIpNumber();

}
