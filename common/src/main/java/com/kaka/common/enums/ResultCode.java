package com.kaka.common.enums;

/**
 * @author jsk
 * @Date 2018/10/15 9:11
 */
public enum ResultCode {
    SUCCESS("success", "操作成功"),
    FAILURE("failure", "操作失败"),
    INTERNAL_SERVER_ERROR("8500", "服务器端内部异常"),
    OK("200", "操作成功");

    private String code;
    private String name;

    ResultCode(String code, String name) {
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
