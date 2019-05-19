package com.kaka.jtest.designpatter.decorator.example;

/**
 * 寒冰射手
 * @author: jsk
 * @date: 2019/5/12 17:41
 */
public class Ashe extends AbstractEnemyHero {

    public Ashe(Hero hero) {
        this.targetHero = hero;
    }

    @Override
    public Integer healthPoint() {
        return targetHero.healthPoint() - 90;
    }

    @Override
    public String description() {
        return targetHero.description() + ", 受到寒冰的普通攻击";
    }
}
