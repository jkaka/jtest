package com.kaka.jtest.jdk.java.test.callback;

import java.util.HashMap;

/**
 * @author jsk
 * @Date 2018/12/3 14:20
 */
public class APP {
    public static void main(String[] args) {
        System.out.println("开始调用远程服务！");

        Agent agent = new Agent();

        agent.onCommand(new HashMap<String, Object>() {{
            put("1", "AA");
            put("2", "BB");
        }}, new EventCallback<>());

        System.out.println("调用远程服务成功！");
    }
}
