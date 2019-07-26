package com.kaka.jtest.designpatter.facade.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/14 15:30
 */
public class StoreFacade {
    private AccountSystem accountSystem;
    private DisCountSystem disCountSystem;
    private HeroSystem heroSystem;

    public StoreFacade(AccountSystem accountSystem, DisCountSystem disCountSystem, HeroSystem heroSystem) {
        this.accountSystem = accountSystem;
        this.disCountSystem = disCountSystem;
        this.heroSystem = heroSystem;
    }

    /**
     * 购买英雄
     *
     * @param heroName 英雄名称
     */
    public void buyHero(String heroName) {
        heroSystem.validateHero(heroName);
        disCountSystem.calculate(heroName);
        accountSystem.settlement();
    }
}
