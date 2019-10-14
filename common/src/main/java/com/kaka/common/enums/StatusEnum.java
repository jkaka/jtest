package com.kaka.common.enums;

/**
 * @author jsk
 * @Date 2018/11/12 20:16
 */
public enum StatusEnum {

    STATUS_Y("Y", "启用中"), STATUS_N("N", "禁用中");

    private String code;
    private String name;

    StatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
