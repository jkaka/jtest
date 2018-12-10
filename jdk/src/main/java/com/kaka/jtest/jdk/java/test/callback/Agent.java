package com.kaka.jtest.jdk.java.test.callback;

import org.w3c.dom.events.EventException;

import java.util.Map;

/**
 * @author jsk
 * @Date 2018/12/3 14:17
 */
public class Agent {

    public void onCommand(Map<String, Object> param, EventCallback<String> callback) {
        System.out.println("接收到参数：" + param);

        // 异步处理,然后执行回调
        AsyncHandler asyncHandler = new AsyncHandler(callback);
        new Thread(asyncHandler).start();
    }

}
