package com.kaka.jtest.designpatter.factory.method.example;

/**
 * @author: jsk
 * @date: 2019/5/25 18:24
 */
public abstract class HeroPool {
    /**
     * 创建的具体实现交给不同的子类,增加或者减少英雄都不改动此方法
     *
     * @param heroName
     */
    void skill(String heroName) {
        Hero hero = createHero(heroName);
        System.out.println("我是" + heroName + ",我的大招是:" + hero.ultimateSkill());
    }

    /**
     * 工厂方法,由具体的子类实现
     *
     * @param heroName
     * @return
     */
    abstract Hero createHero(String heroName);
}
