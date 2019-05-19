package com.kaka.jtest.openutils.beans;

import lombok.Data;

import java.util.Map;

/**
 * @author: jsk
 * @date: 2019/5/9 13:50
 */
@Data
public class FiledTwoObject {
    private Map<String, String> mapParam;

    public void setMapParam(Map<String, String> mapParam) {
        this.mapParam = mapParam;
    }
}
