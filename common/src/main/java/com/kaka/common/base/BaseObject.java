package com.kaka.common.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author jsk
 * @Date 2018/12/14 11:29
 */
public class BaseObject implements Serializable {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
