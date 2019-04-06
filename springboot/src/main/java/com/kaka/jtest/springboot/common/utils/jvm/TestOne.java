package com.kaka.jtest.springboot.common.utils.jvm;

/**
 * @author: jsk
 * @date: 2019/3/25 20:37
 */
public class TestOne {

    private static String a = "test2";
    public static void main(String[] args) {
        System.out.println("8888888888888");
        System.out.println("测试OK？" + a);
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        System.out.println(Arrays.toString(webApplicationContext.getBeanDefinitionNames()));
//        HelloController helloController = webApplicationContext.getBean("helloController", HelloController.class);
//        helloController.testExceptionHandler("aa");
        System.out.println("调用成功");
    }
}
