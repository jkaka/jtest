package com.kaka.jtest.designpatter.state.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/28 12:11
 */
public class NidaleeLionState implements NidaleeState {
    @Override
    public void skillQ() {
        System.out.println("Q技能：下次攻击将造成魔法伤害，目标每损失百分之1的生命值就会多造成伤害。");
    }

    @Override
    public void skillW() {
        System.out.println("W技能：奈德丽猛扑向目标方向，落地时造成范围魔法伤害。");
    }
}
