package com.kaka.jtest.designpatter.builder.exmaple;

/**
 * 亚索的技能生成器
 *
 * @author: jsk
 * @date: 2019/8/10 15:56
 */
public class YasuoBuilder extends AbstractHeroBuilder {
    @Override
    public void buildSkillQ() {
        hero.setSkillQ("Q技能：斩钢闪");
    }

    @Override
    public void buildSkillW() {
        hero.setSkillW("W技能：风之障壁");
    }

    @Override
    public void buildSkillE() {
        hero.setSkillE("E技能：踏前斩");
    }

    @Override
    public void buildSkillR() {
        hero.setSkillR("R技能：狂风绝息斩");
    }
}
