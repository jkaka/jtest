package com.kaka.jtest.openutils.dataobject;

import lombok.Data;

/**
 * @author shuangkaijia
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
