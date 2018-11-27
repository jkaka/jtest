package com.kaka.jtest.designpatter.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 众星之子  索拉卡
 *
 * @author jsk
 * @Date 2018/11/17 13:49
 */
public class Soraka implements Subject {
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public void executeR() {
        System.out.println("索拉卡执行R技能,给队友加血!");
        this.notifyObservers();
    }

}
