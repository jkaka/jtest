package com.kaka.jtest.designpatter.template.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/14 16:58
 */
public class Fizz extends AbstractHeroSkill {
    @Override
    public void skillQ() {
        System.out.println("Q:淘气打击");
    }

    @Override
    public void skillW() {
        System.out.println("W:海石三叉戟");
    }

    @Override
    public void skillE() {
        System.out.println("E:古灵/精怪");
    }

    @Override
    public void skillR() {
        System.out.println("R:巨鲨强袭");
    }
}
