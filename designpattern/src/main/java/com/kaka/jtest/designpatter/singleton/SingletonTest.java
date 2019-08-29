package com.kaka.jtest.designpatter.singleton;

/**
 * @author: jsk
 * @date: 2019/8/23 21:13
 */
public class SingletonTest {

    public static void main(String[] args) {
        BadMashSingleton.getInstance().getConnection();
        IdlerSingleton.getInstance().getConnection();
        DCLSingleton.getInstance().getConnection();
        EnumSingleton.INSTANCE.getConnection();
    }

}
