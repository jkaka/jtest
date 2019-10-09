package com.kaka.jtest.jdk.java.keyword;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-08 15:41
 */
public class ModifyField {
    /**
     * 该变量，只有在当前类中可以使用
     */
    private String a;
    /**
     * 没有关键字修饰，在当前类或者在当前包中的类可以使用，这些都是该类的朋友  (其实没有friendly、default关键字)
     */
    String b;
    /**
     * 受保护的关键字，当前包中的类和该类的子类可以使用该变量
     */
    protected String c;
    /**
     * 公开的，所有类都可以使用该变量
     */
    public String d;
}
