package com.kaka.jtest.springboot.biz.dataobject;

import lombok.Data;

/**
 * @author shuangkaijia
 */

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
