package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import com.kaka.jtest.jdk.model.HotSwapBean;

import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/4/3 15:40
 */
public class ReplaceAgentMain {
    public static void main(String[] args) {
        HotSwapBean hotSwapBean = new HotSwapBean();
        while (true) {
            try {
                hotSwapBean.say();
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
