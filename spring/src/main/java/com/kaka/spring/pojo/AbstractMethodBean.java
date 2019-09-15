package com.kaka.spring.pojo;

/**
 * @author: jsk
 * @date: 2019/9/15 16:27
 */
public abstract class AbstractMethodBean {
    /**
     * 抽象方法设置为private没有意义,因为private的方法子类无法覆盖和使用
     *
     * @return
     */
    public abstract Animal getAnimalBean();

    public void printSay() {
        getAnimalBean().say();
    }

}
