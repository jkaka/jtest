package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.model.Interface;
import com.kaka.jtest.jdk.model.Person;
import com.kaka.jtest.jdk.model.RealObject;
import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/6/25 14:22
 */
public class ClassTest {
    @Test
    public void forName() {
        // class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块，还会执行给静态变量赋值的静态方法
        // classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
    }

    /**
     * name - 所需类的完全限定名
     * initialize - 是否必须初始化类
     * loader - 用于加载类的类加载器
     */
    @Test
    public void forNameTest() throws ClassNotFoundException {
        Class.forName("", true, ClassLoader.getSystemClassLoader());
    }

    /**
     * RealObject.class是不是interfaceClass的子类或者子接口
     */
    @Test
    public void isAssignableFromTest() {
        Class<Interface> interfaceClass = Interface.class;
        System.out.println(interfaceClass.isAssignableFrom(RealObject.class));
        System.out.println(interfaceClass.isAssignableFrom(Person.class));
    }

    /**
     * 检测是否为基本类型
     */
    @Test
    public void isPrimitiveTest() {
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass.isPrimitive());
    }


}
