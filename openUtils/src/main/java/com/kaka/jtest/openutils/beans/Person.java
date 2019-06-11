package com.kaka.jtest.openutils.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jsk
 * @date: 2019/5/9 11:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;

    public void sayHello() {
        System.out.println("hello...");
    }
}
