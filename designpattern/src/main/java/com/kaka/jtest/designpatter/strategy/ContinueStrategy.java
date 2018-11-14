package com.kaka.jtest.designpatter.strategy;

/**
 * 继续释放技能的策略
 *
 * @author jsk
 * @Date 2018/11/10 12:45
 */
public class ContinueStrategy implements Death {
    @Override
    public void action(String name) {
        System.out.println(name + "已被击杀,可以继续释放5s技能！");
    }
}
