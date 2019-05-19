package com.kaka.jtest.jdk.java.grammar;

/**
 * @author: jsk
 * @date: 2019/4/16 19:19
 */
public class ExtendsTest {
    public ExtendsTest(int a) {
    }
}

class Test extends ExtendsTest {

    /**
     * 父类没有无参构造器,子类就必须显示调用父类的构造器
     *
     * @param a
     */
    public Test(int a) {
        super(a);
    }
}
