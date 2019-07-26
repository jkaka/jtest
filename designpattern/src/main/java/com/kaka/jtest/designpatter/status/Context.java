package com.kaka.jtest.designpatter.status;

/**
 * @author: jsk
 * @date: 2019/7/26 13:54
 */
public class Context {

    private State stateA;
    private State stateB;

    private State currentStat;

    public Context() {
        stateA = new ConcreteStateA(this);
        stateB = new ConcreteStateB(this);
        currentStat = stateA;
    }

    void request() {
        currentStat.handle();
    }

    public State getStateA() {
        return stateA;
    }

    public void setStateA(State stateA) {
        this.stateA = stateA;
    }

    public State getStateB() {
        return stateB;
    }

    public void setStateB(State stateB) {
        this.stateB = stateB;
    }

    public State getCurrentStat() {
        return currentStat;
    }

    public void setCurrentStat(State currentStat) {
        this.currentStat = currentStat;
    }
}
