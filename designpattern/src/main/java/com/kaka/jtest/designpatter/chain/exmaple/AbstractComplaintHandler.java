package com.kaka.jtest.designpatter.chain.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/11 13:18
 */
public abstract class AbstractComplaintHandler {
    private AbstractComplaintHandler nextHandler;

    public AbstractComplaintHandler(AbstractComplaintHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractComplaintHandler getNextHandler() {
        return nextHandler;
    }

    public abstract void handlerRequest(Complain complain);
}
