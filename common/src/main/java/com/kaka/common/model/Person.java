package com.kaka.common.model;

import lombok.Data;

/**
 * @author jsk
 * @Date 2018/11/21 14:52
 */
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
