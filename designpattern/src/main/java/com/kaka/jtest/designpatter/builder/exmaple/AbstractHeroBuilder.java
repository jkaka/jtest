package com.kaka.jtest.designpatter.builder.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/10 15:49
 */
public abstract class AbstractHeroBuilder {

    protected Hero hero = new Hero();

    public abstract void buildSkillQ();

    public abstract void buildSkillW();

    public abstract void buildSkillE();

    public abstract void buildSkillR();

    public Hero build() {
        return hero;
    }
}
