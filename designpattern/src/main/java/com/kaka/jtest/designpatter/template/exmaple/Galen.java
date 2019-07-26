package com.kaka.jtest.designpatter.template.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/14 16:57
 */
public class Galen extends AbstractHeroSkill {
    @Override
    public void skillQ() {
        System.out.println("Q:致命打击");
    }

    @Override
    public void skillW() {
        System.out.println("W:勇气");
    }

    @Override
    public void skillE() {
        System.out.println("E:审判");
    }

    @Override
    public void skillR() {
        System.out.println("R:德玛西亚正义");
    }

    @Override
    public boolean hook() {
        System.out.println("盖伦的W技能不是伤害技能,无需释放！");
        return false;
    }
}
