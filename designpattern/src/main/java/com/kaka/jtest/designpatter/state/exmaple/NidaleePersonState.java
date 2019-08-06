package com.kaka.jtest.designpatter.state.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/28 12:11
 */
public class NidaleePersonState implements NidaleeState {
    @Override
    public void skillQ() {
        System.out.println("Q技能：奈德丽投掷她的标枪，造成魔法伤害。");
    }

    @Override
    public void skillW() {
        System.out.println("W技能：奈德丽放置一个陷阱，最多可持续2分钟。在被敌人踩中时，陷阱会将目标暴露在视野内。");
    }
}
