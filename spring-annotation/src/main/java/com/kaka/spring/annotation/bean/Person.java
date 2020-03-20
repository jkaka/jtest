package com.kaka.spring.annotation.bean;

import lombok.Data;

/**
 * @author: jsk
 * @date: 2019/3/12 22:40
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person(){}

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
