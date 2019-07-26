package com.kaka.jtest.designpatter.template.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/14 17:02
 */
public class TemplateMethodClient {
    public static void main(String[] args) {
        AbstractHeroSkill galen = new Galen();
        AbstractHeroSkill fizz = new Fizz();
        System.out.println("盖伦的伤害技能演示...");
        galen.harmSkill();
        System.out.println("---------------------------");
        System.out.println("小鱼人的伤害技能演示...");
        fizz.harmSkill();
    }
}
