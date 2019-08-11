package com.kaka.jtest.designpatter.chain;

/**
 * @author: jsk
 * @date: 2019/8/10 11:38
 */
public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    public AbstractHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public abstract void handlerRequest();
}
