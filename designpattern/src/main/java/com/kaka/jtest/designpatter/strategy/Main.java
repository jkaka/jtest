package com.kaka.jtest.designpatter.strategy;

/**
 * @author jsk
 * @Date 2018/11/10 12:52
 */
public class Main {
    public static void main(String[] args) {
        BlackScreenStrategy blackScreenStrategy = new BlackScreenStrategy();
        ContinueStrategy continueStrategy = new ContinueStrategy();

        Hero galen = new Hero("盖伦", blackScreenStrategy);
        Hero thane = new Hero("塞恩", continueStrategy);

        galen.afterDeath();
        thane.afterDeath();
    }
}
