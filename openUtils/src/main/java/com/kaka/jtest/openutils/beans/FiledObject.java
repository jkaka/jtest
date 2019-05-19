package com.kaka.jtest.openutils.beans;

import lombok.Data;

import java.util.Map;

/**
 * @author: jsk
 * @date: 2019/5/9 11:57
 */
@Data
public class FiledObject {
    private Integer id;
    private static String name;
    private FiledTwoObject filedTwoObject;
}
