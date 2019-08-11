package com.kaka.jtest.designpatter.builder.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/10 16:11
 */
public class HeroClient {
    public static void main(String[] args) {
        AbstractHeroBuilder rivenBuilder = new RivenBuilder();
        AbstractHeroBuilder yasuoBuilder = new YasuoBuilder();

        SkillDirector rivenSkillDirector = new SkillDirector(rivenBuilder);
        Hero riven = rivenSkillDirector.construct();
        System.out.println("瑞文的技能！");
        System.out.println(riven.getSkillQ());
        System.out.println(riven.getSkillW());
        System.out.println(riven.getSkillE());
        System.out.println(riven.getSkillR());

        System.out.println("------------------------");
        System.out.println("亚索的技能！");
        SkillDirector yasuoSkillDirector = new SkillDirector(yasuoBuilder);
        Hero yasuo = yasuoSkillDirector.construct();
        System.out.println(yasuo.getSkillQ());
        System.out.println(yasuo.getSkillW());
        System.out.println(yasuo.getSkillE());
        System.out.println(yasuo.getSkillR());
    }
}
