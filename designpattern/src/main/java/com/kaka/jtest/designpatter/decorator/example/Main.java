package com.kaka.jtest.designpatter.decorator.example;

/**
 * @author: jsk
 * @date: 2019/5/12 17:53
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个盖伦
        Galen galen = new Galen();

        // 经过艾希的装饰(攻击)
        Ashe ashe = new Ashe(galen);

        // 经过卡特的装饰(攻击)
        Catalina catalina = new Catalina(ashe);

        System.out.println(catalina.description());
        System.out.println("目前总生命值:" + catalina.healthPoint());
    }
}
