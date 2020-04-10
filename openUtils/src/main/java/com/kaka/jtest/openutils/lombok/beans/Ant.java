package com.kaka.jtest.openutils.lombok.beans;

import lombok.Data;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/02 14:25:30
 */
@Data
public class Ant {
    private Integer id;

    public void setId(Integer id) {
        System.out.println("自己写的setId方法...");
        this.id = id;
    }
}
