package com.kaka.jtest.designpatter.builder.exmaple;

/**
 * 瑞文的技能生成器
 *
 * @author: jsk
 * @date: 2019/8/10 15:56
 */
public class RivenBuilder extends AbstractHeroBuilder {
    @Override
    public void buildSkillQ() {
        hero.setSkillQ("Q技能：折翼之舞");
    }

    @Override
    public void buildSkillW() {
        hero.setSkillW("W技能：镇魂怒吼");
    }

    @Override
    public void buildSkillE() {
        hero.setSkillE("E技能：勇往直前");
    }

    @Override
    public void buildSkillR() {
        hero.setSkillR("R技能：放逐之锋");
    }
}
