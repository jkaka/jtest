package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * @author: jsk
 * @date: 2019/6/1 18:27
 */
public interface GameFactory {
    /**
     * 获取法师
     *
     * @return
     */
    Mage getMage();

    /**
     * 获取射手
     *
     * @return
     */
    Shooter getShooter();
}
