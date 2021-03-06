package com.kaka.jtest.openutils.beans;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jsk
 * @Date 2018/10/26 16:13
 */
@Data
public class CommonClass {
    private int age;
    private String name;
    private Date birthday;
    private int[] array;
    private Person person;
    private List<String> stringList;
}
