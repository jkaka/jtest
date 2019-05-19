package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import com.alibaba.fastjson.JSONObject;

import java.lang.instrument.Instrumentation;

/**
 * Java agent是一种特殊的Java程序（Jar文件），它是Instrumentation的客户端。与普通Java程序通过main方法启动不同，
 * agent并不是一个可以单独启动的程序，而必须依附在一个Java应用程序（JVM）上，与它运行在同一个进程中，通过Instrumentation API与虚拟机交互。
 * Java agent与Instrumentation密不可分，二者也需要在一起使用。因为Instrumentation的实例会作为参数注入到Java agent的启动方法中。
 *
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
        /**
         * 注册一个Transformer到 TransformerManager，从此之后的类加载都会被Transformer拦截。
         * Transformer可以直接对类的字节码byte[]进行修改
         * 对于已经加载过的类，可以执行retransformClasses来重新触发这个Transformer的拦截。类加载的字节码被修改后，
         * 除非再次被retransform，否则不会恢复。
         */
        instrumentation.addTransformer(new SimpleTransformer(filePath, className), true);
        /**
         * 获取当前被JVM加载的所有类对象
         */
        instrumentation.getAllLoadedClasses();
        System.out.println("ClassFileTransformer成功");
        try {
            System.out.println("className(前):" + className);
            className = className.replace("/", ".");
            System.out.println("className(后):" + className);
            Class<?> clz = Class.forName(className);
            /**
             * 对JVM已经加载的类重新触发类加载。使用的就是上面注册的Transformer。
             * retransformation可以修改方法体，但是不能变更方法签名、增加和删除方法/类的成员属性
             */
            instrumentation.retransformClasses(clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end agent");
    }
}
