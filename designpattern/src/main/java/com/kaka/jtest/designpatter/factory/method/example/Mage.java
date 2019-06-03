package com.kaka.jtest.designpatter.factory.method.example;

/**
 * 法师
 *
 * @author: jsk
 * @date: 2019/5/25 18:28
 */
public class Mage extends HeroPool {
    @Override
    Hero createHero(String heroName) {
        if("karthus".equals(heroName)){
            return new Karthus();
        }
        return null;
    }
}
