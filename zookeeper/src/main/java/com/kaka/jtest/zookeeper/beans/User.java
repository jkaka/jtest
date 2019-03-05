package com.kaka.jtest.zookeeper.beans;

import java.io.Serializable;

/**
 * @author jsk
 * @Date 2019/3/4 19:51
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
