package com.kaka.jtest.designpatter.facade.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/14 15:39
 */
public class FacadeClient {
    public static void main(String[] args) {
        AccountSystem accountSystem = new AccountSystem();
        DisCountSystem disCountSystem = new DisCountSystem();
        HeroSystem heroSystem = new HeroSystem();

        StoreFacade storeFacade = new StoreFacade(accountSystem, disCountSystem, heroSystem);
        System.out.println("使用外观模式购买一个盖伦英雄!");
        storeFacade.buyHero("盖伦");
    }
}
