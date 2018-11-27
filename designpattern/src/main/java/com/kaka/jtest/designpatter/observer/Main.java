package com.kaka.jtest.designpatter.observer;

/**
 * @author jsk
 * @Date 2018/11/17 13:56
 */
public class Main {
    public static void main(String[] args) {
        // 1.创建三个英雄和索拉卡
        Hero Garen = new Hero("盖伦");
        Hero Ashe = new Hero("艾希");
        Hero Brand= new Hero("布兰德");

        Soraka soraka = new Soraka();

        // 2.把这三个英雄注册到索拉卡
        soraka.registerObserver(Garen);
        soraka.registerObserver(Ashe);
        soraka.registerObserver(Brand);

        // 3.索拉卡执行R技能
        soraka.executeR();
    }
}
