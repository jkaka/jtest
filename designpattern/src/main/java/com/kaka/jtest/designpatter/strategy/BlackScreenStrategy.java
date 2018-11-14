package com.kaka.jtest.designpatter.strategy;

/**
 * 黑屏的策略
 *
 * @author jsk
 * @Date 2018/11/10 12:46
 */
public class BlackScreenStrategy implements Death {
    @Override
    public void action(String name) {
        System.out.println(name + "已被击杀,黑屏中,无法释放技能！");
    }
}
