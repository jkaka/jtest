package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * 中级模式下的法师
 *
 * @author: jsk
 * @date: 2019/6/1 18:30
 */
public class BigMage implements Mage {
    @Override
    public String getName() {
        return "我是一个超级厉害的法师!  法术伤害500+";
    }
}
