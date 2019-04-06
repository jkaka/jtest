package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.jdk.model.HotSwapBean;

import java.lang.instrument.Instrumentation;

/**
 * @author: jsk
 * @date: 2019/4/3 15:33
 */
public class ReplaceAgent {
    public static void agentmain(String agentArgument, Instrumentation instrumentation) {
        System.out.println("start agent...");
        JSONObject jsonObject = JSONObject.parseObject(agentArgument);
        String filePath = jsonObject.getString("filePath");
        String className = jsonObject.getString("className");

        if (filePath == null || className == null) {
            System.out.println(String.format("wrong agentArgument=%s", agentArgument));
            return;
        }
        instrumentation.addTransformer(new SimpleTransformer(filePath, className), true);
        System.out.println("ClassFileTransformer成功");
        try {
            instrumentation.retransformClasses(HotSwapBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end agent");
    }
}
