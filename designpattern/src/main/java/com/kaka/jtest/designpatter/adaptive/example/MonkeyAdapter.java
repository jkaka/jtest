package com.kaka.jtest.designpatter.adaptive.example;

/**
 * @author: jsk
 * @date: 2019/7/13 13:00
 */
public class MonkeyAdapter implements Hero {
    private MonkeyKing monkeyKing;

    public MonkeyAdapter(MonkeyKing monkeyKing) {
        this.monkeyKing = monkeyKing;
    }

    @Override
    public void skillQ() {
        System.out.println("使用适配器,调用猴子(被适配者)的1技能");
        monkeyKing.skill1();
    }

    @Override
    public void skillW() {
        System.out.println("使用适配器,调用猴子(被适配者)的2技能");
        monkeyKing.skill2();
    }
}
