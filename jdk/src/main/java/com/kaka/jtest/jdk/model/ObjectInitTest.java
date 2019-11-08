package com.kaka.jtest.jdk.model;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-07 17:34
 */
public class ObjectInitTest {
    private int age = 9;
    private String name;
    private ObjectInitTest2 objectInitTest2;

    public ObjectInitTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    {
        // 执行构造方法前,先执行代码块    此时对象的属性都是原始值
        System.out.println("age:" + age);
        objectInitTest2 = new ObjectInitTest2(this);
    }

    public static void main(String[] args) {
        ObjectInitTest objectInitTest = new ObjectInitTest(22, "jsk");
        System.out.println(objectInitTest);
    }

}
