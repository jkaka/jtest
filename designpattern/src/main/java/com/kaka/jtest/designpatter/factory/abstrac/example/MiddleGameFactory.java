package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * @author: jsk
 * @date: 2019/6/1 18:26
 */
public class MiddleGameFactory implements GameFactory {
    @Override
    public Mage getMage() {
        return new BigMage();
    }

    @Override
    public Shooter getShooter() {
        return new BigShooter();
    }
}
