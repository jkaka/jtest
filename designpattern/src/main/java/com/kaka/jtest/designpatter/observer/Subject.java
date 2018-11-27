package com.kaka.jtest.designpatter.observer;

/**
 * 主题接口
 *
 * @author jsk
 * @Date 2018/11/17 13:41
 */
public interface Subject {
    /**
     * 注册观察者
     *
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     *
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
