package com.kaka.jtest.designpatter.decorator.example;

/**
 * 卡特琳娜
 *
 * @author: jsk
 * @date: 2019/5/12 17:52
 */
public class Catalina extends AbstractEnemyHero {

    public Catalina(Hero hero) {
        this.targetHero = hero;
    }

    @Override
    public Integer healthPoint() {
        return targetHero.healthPoint() - 110;
    }

    @Override
    public String description() {
        return targetHero.description() + ", 受到卡特飞镖的攻击";
    }
}
