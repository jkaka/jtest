package com.kaka.jtest.designpatter.factory.method.example;

/**
 * 老鼠·图奇
 *
 * @author: jsk
 * @date: 2019/5/25 18:21
 */
public class Twitch implements Hero {
    @Override
    public String ultimateSkill() {
        return "火力全开...";
    }
}
