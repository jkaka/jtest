package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * 简单模式下的法师
 *
 * @author: jsk
 * @date: 2019/6/1 18:29
 */
public class SmallMage implements Mage {
    @Override
    public String getName() {
        return "我是一个弱小的法师...    法术伤害100+";
    }
}
