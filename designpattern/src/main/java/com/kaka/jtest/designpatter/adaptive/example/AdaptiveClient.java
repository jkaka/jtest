package com.kaka.jtest.designpatter.adaptive.example;

/**
 * @author: jsk
 * @date: 2019/7/13 13:08
 */
public class AdaptiveClient {
    public static void main(String[] args) {
        // 1.创建被适配者
        MonkeyKing monkeyKing = new MonkeyKing();
        // 2.创建适配器
        Hero hero = new MonkeyAdapter(monkeyKing);
        hero.skillQ();
        hero.skillW();
    }
}
