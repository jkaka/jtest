package com.kaka.jtest.designpatter.strategy;

/**
 * 英雄实体类
 * @author jsk
 * @Date 2018/11/10 12:40
 */
public class Hero {

    private String name;
    private Death deathStrategy;

    public Hero(String name, Death deathStrategy) {
        this.name = name;
        this.deathStrategy = deathStrategy;
    }

    public void afterDeath(){
        deathStrategy.action(name);
    }
}
