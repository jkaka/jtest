package com.kaka.jtest.designpatter.factory.method.example;

/**
 * 射手工厂
 *
 * @author: jsk
 * @date: 2019/5/25 18:28
 */
public class Shooter extends HeroPool {
    @Override
    Hero createHero(String heroName) {
        if("twitch".equals(heroName)){
            return new Twitch();
        }
        return null;
    }
}
