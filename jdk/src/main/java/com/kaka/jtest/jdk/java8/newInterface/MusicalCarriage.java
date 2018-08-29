package com.kaka.jtest.jdk.java8.newInterface;

/**
 * @author shuangkaijia
 */
public class MusicalCarriage implements Carriage, Jukebox {
    /**
     * javac并不明确应该继承哪个接口中的方法
     * 因此使用增强的super语法
     * 或者自己实现该默认方法
     * @return
     */
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}