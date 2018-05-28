package com.kaka.test.springboot.common.model;

import java.io.Serializable;

public class BaseObject implements Serializable {
    public BaseObject() {
    }

    @Override
    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
        return "";
    }

}