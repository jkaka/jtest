package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * @author: jsk
 * @date: 2019/6/1 18:26
 */
public class SimpleGameFactory implements GameFactory {
    @Override
    public Mage getMage() {
        return new SmallMage();
    }

    @Override
    public Shooter getShooter() {
        return new SmallShooter();
    }
}
