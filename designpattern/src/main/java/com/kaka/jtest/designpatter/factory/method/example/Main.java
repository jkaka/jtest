package com.kaka.jtest.designpatter.factory.method.example;

/**
 * @author: jsk
 * @date: 2019/5/25 18:39
 */
public class Main {
    public static void main(String[] args) {
//        HeroPool mageHeroPool = new Mage();
//        mageHeroPool.skill("karthus");

        HeroPool shooterHeroPool = new Shooter();
        shooterHeroPool.skill("twitch");
    }
}
