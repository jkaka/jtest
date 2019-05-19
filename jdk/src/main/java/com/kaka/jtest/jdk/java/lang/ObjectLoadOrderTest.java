package com.kaka.jtest.jdk.java.lang;

/**
 * 实例初始化不一定要在类初始化结束之后才开始初始化。
 * 需要注意的是如果类变量是final，编译时javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值。
 * static final int b=112，那么在准备阶段b的值就是112，而不再是0了。
 *
 * @author: jsk
 * @date: 2019/4/17 13:52
 */
public class ObjectLoadOrderTest {
    public static void main(String[] args) {
        staticFunction();
    }

    /**
     * 实例初始化嵌入到了静态初始化流程中,导致了实例初始化完全至于静态初始化之前
     */
    static ObjectLoadOrderTest st = new ObjectLoadOrderTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    ObjectLoadOrderTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
