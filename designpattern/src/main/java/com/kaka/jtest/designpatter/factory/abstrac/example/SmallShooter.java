package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * 简单模式下的射手
 *
 * @author: jsk
 * @date: 2019/6/1 18:31
 */
public class SmallShooter implements Shooter {
    @Override
    public String getName() {
        return "我是一个弱小的射手... 攻击力100+";
    }
}
