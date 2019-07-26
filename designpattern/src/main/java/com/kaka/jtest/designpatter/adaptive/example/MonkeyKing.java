package com.kaka.jtest.designpatter.adaptive.example;

/**
 * @author: jsk
 * @date: 2019/7/13 12:58
 */
public class MonkeyKing {
    /**
     * 被收购公司的1技能,对应目标接口的Q节能
     */
    void skill1() {
        System.out.println("猴王技能：粉碎打击！");
    }

    /**
     * 被收购公司的2技能,对应目标接口的W节能
     */
    void skill2() {
        System.out.println("猴王技能：真假猴王！");
    }
}
