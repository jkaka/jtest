package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import com.alibaba.fastjson.JSONObject;

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
        // 将自定义的 Transformer 注册到 TransformerManager 里
        instrumentation.addTransformer(new SimpleTransformer(filePath, className), true);
        System.out.println("ClassFileTransformer成功");
        try {
            System.out.println("className(前):" + className);
            className = className.replace("/", ".");
            System.out.println("className(后):" + className);
            Class<?> clz = Class.forName(className);
            instrumentation.retransformClasses(clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end agent");
    }
}
