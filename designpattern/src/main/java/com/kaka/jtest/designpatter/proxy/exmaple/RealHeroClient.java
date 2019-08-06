package com.kaka.jtest.designpatter.proxy.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/3 11:52
 */
public class RealHeroClient {


    public static void main(String[] args) {
        // 1.创建英雄实例
        RealHero realHero = new RealHero();
        // 2.获取英雄实例的代理对象
        HeroInvocationHandler heroInvocationHandler = new HeroInvocationHandler(realHero);
        Hero proxyHero = heroInvocationHandler.getProxyHero();

        // 调用代理的普攻、技能方法
        proxyHero.attack(new Double(Math.random() * 100).intValue());
        proxyHero.skill(new Double(Math.random() * 100).intValue());
        proxyHero.attack(new Double(Math.random() * 100).intValue());
        proxyHero.skill(new Double(Math.random() * 100).intValue());
    }
}
