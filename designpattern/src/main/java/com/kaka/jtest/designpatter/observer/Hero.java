package com.kaka.jtest.designpatter.observer;

/**
 * 英雄实体类
 *
 * @author jsk
 * @Date 2018/11/17 13:55
 */
public class Hero implements Observer {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + "开始回血...");
    }
}
