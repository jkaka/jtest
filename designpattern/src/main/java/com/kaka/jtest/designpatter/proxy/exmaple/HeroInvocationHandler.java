package com.kaka.jtest.designpatter.proxy.exmaple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: jsk
 * @date: 2019/8/3 11:46
 */
public class HeroInvocationHandler implements InvocationHandler {
    private Hero hero;
    private Integer attackDamage = 0;
    private Integer skillDamage = 0;

    public HeroInvocationHandler(Hero hero) {
        this.hero = hero;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(hero, args);
        if("attack".equals(method.getName())){
            attackDamage += (Integer) args[0];
        }
        if("skill".equals(method.getName())){
            skillDamage += (Integer) args[0];
        }
        System.out.println("--------------------该英雄普攻共造成总伤害:" + attackDamage);
        System.out.println("--------------------该英雄技能共造成总伤害:" + skillDamage);
        return invoke;
    }

    public Hero getProxyHero(){
        ClassLoader classLoader = hero.getClass().getClassLoader();
        Class<?>[] interfaces = hero.getClass().getInterfaces();
        return (Hero) Proxy.newProxyInstance(classLoader, interfaces, this);
    }
}
