package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * 中级模式下的射手
 *
 * @author: jsk
 * @date: 2019/6/1 18:30
 */
public class BigShooter implements Shooter {
    @Override
    public String getName() {
        return "我是一个超级厉害的射手！   攻击力500+";
    }
}
