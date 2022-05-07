package com.jstarcraft.nlp.locale;

import java.util.Locale;

/**
 * 地址
 * 
 * @author Birdy
 *
 */
public interface NlpAddress {

    /**
     * 国家
     * 
     * @return
     */
    public Locale getCountry();

    /**
     * 省份
     * 
     * @return
     */
    public String getProvince();

    /**
     * 城市
     * 
     * @return
     */
    public String getCity();

    /**
     * 辖区
     * 
     * @return
     */
    public String getDistrict();

}
