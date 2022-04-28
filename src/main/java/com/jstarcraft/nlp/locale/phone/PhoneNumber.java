package com.jstarcraft.nlp.locale.phone;

/**
 * 手机号码
 * 
 * @author Birdy
 *
 */
public class PhoneNumber {

    private String number;
    /** 省份 */
    private String province;
    /** 城市 */
    private String city;
    /** 区号 */
    private String areaCode;
    /** 邮编 */
    private String zipCode;
    /** 类型 */
    private String type;

    public String getNumber() {
        return number;
    }

    void setNumber(String phoneNumber) {
        this.number = phoneNumber;
    }

    public String getProvince() {
        return province;
    }

    void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneType() {
        return type;
    }

    void setPhoneType(String phoneType) {
        this.type = phoneType;
    }

    @Override
    public String toString() {
        return "PhoneNumber [number=" + number + ", province=" + province + ", city=" + city + ", areaCode=" + areaCode + ", zipCode=" + zipCode + ", phoneType=" + type + "]";
    }

}
