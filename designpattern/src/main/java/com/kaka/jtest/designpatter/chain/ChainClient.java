package com.kaka.jtest.designpatter.chain;

/**
 * @author: jsk
 * @date: 2019/8/10 11:47
 */
public class ChainClient {
    public static void main(String[] args) {
        AbstractHandler twoHandler = new TwoHandler(null);
        AbstractHandler oneHandler = new OneHandler(twoHandler);

        oneHandler.handlerRequest();
    }
}
