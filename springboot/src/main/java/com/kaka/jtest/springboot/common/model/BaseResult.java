package com.kaka.jtest.springboot.common.model;

public class BaseResult<T> extends BaseObject {
    /**
     * 操作结果标志
     */
    private Boolean isSuccess;

    /**
     * 操作结果代码
     */
    private String code;

    /**
     * 操作结果描述
     */
    private String message;

    /**
     * 操作结果集
     */
    private T data;

    public BaseResult() {
        this.isSuccess = Boolean.FALSE;
        this.code = "failure";
    }

    public Boolean getSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(Boolean success) {
        this.isSuccess = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}