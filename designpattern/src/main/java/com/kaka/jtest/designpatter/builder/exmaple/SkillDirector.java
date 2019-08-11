package com.kaka.jtest.designpatter.builder.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/10 16:08
 */
public class SkillDirector {
    private AbstractHeroBuilder heroBuilder;

    public SkillDirector(AbstractHeroBuilder heroBuilder) {
        this.heroBuilder = heroBuilder;
    }

    public Hero construct(){
        heroBuilder.buildSkillQ();
        heroBuilder.buildSkillW();
        heroBuilder.buildSkillE();
        heroBuilder.buildSkillR();
        return heroBuilder.build();
    }
}
