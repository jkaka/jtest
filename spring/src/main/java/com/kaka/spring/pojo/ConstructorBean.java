package com.kaka.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: jsk
 * @date: 2019/9/17 21:47
 */
@Data
public class ConstructorBean {
    private String a;
    private String b;

    public ConstructorBean(String a, String b) {
        this.a = a;
        this.b = b;
    }
}
