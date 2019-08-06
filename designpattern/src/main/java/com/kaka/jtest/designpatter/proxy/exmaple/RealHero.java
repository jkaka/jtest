package com.kaka.jtest.designpatter.proxy.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/3 11:45
 */
public class RealHero implements Hero {
    @Override
    public void attack(Integer damage) {
        System.out.println("使用普攻,对敌人造成伤害值:" + damage);
    }

    @Override
    public void skill(Integer damage) {
        System.out.println("使用技能,对敌人造成伤害值:" + damage);
    }
}
