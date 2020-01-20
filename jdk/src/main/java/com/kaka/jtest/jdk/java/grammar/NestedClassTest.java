package com.kaka.jtest.jdk.java.grammar;

/**
 * 嵌套类
 *
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/01/19 19:37:55
 */
public class NestedClassTest {

    private String name;
    /**
     * 去掉private是为了简化内部类的访问
     * 如果属性为private时，编译器会生成静态的访问方法来提供给内部类访问
     */
    Integer age;

    class Nested {
        public void methodA() {
            System.out.println(NestedClassTest.this.name);
        }

        public void methodB() {
            System.out.println(NestedClassTest.this.age);
        }
    }

    public static void main(String[] args) {
        Nested nested = new NestedClassTest().new Nested();
        nested.methodA();
        nested.methodB();
    }
}
