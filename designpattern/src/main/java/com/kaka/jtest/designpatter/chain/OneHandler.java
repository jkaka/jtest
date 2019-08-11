package com.kaka.jtest.designpatter.chain;

/**
 * @author: jsk
 * @date: 2019/8/10 11:45
 */
public class OneHandler extends AbstractHandler {
    public OneHandler(AbstractHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handlerRequest() {
        System.out.println("one处理器,处理请求开始...");
        if (this.getNextHandler() != null) {
            this.getNextHandler().handlerRequest();
        }
        System.out.println("one处理器,处理请求结束...");
    }
}
