package com.kaka.spring.pojo;

import lombok.Data;

/**
 * @author: jsk
 * @date: 2019/9/17 21:47
 */
@Data
public class ConstructorBean {
    private String a;
    private String b;

    public ConstructorBean(String a) {
        this.a = a;
    }
}
