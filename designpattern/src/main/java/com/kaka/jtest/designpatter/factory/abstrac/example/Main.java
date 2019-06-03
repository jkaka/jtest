package com.kaka.jtest.designpatter.factory.abstrac.example;

/**
 * @author: jsk
 * @date: 2019/6/1 18:34
 */
public class Main {
    public static void main(String[] args) {
        GameFactory gameFactory = new SimpleGameFactory();
        start(gameFactory);

        System.out.println("*******结束了*********");
        System.out.println("游戏太简单了,换个难度等级吧！");

        gameFactory = new MiddleGameFactory();
        start(gameFactory);
    }

    public static void start(GameFactory gameFactory) {
        System.out.println("游戏开始了！");
        System.out.println(gameFactory.getMage().getName());
        System.out.println(gameFactory.getShooter().getName());
    }
}
