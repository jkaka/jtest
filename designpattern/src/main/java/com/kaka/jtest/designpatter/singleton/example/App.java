package com.kaka.jtest.designpatter.singleton.example;

/**
 * @author: jsk
 * @date: 2019/6/29 14:52
 */
public class App {

    public static void main(String[] args) {
        System.out.println("我是寒冰,进入商店:" + Store.getInstance().getStoreName());
        System.out.println("我是盖伦,进入商店:" + Store.getInstance().getStoreName());
        System.out.println("我是流浪法师,进入商店:" + Store.getInstance().getStoreName());
    }
}
