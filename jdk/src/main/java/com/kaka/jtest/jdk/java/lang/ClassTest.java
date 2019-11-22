package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.model.Father;
import com.kaka.jtest.jdk.model.Interface;
import com.kaka.jtest.jdk.model.Person;
import com.kaka.jtest.jdk.model.RealObject;
import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/6/25 14:22
 */
public class ClassTest {

    /**
     * class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块，还会执行给静态变量赋值的静态方法
     * classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
     */
    @Test
    public void forName() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.kaka.jtest.jdk.model.Son");
        System.out.println(aClass);
    }

    /**
     * name - 所需类的完全限定名
     * initialize - 是否必须初始化类
     * loader - 用于加载类的类加载器
     */
    @Test
    public void forNameAllParam() throws ClassNotFoundException {
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


    /**
     * 类型转换
     */
    @Test
    public void castTest() {
        Interface anInterface = Interface.class.cast(new RealObject());
        anInterface.doSomething();
    }

    @Test
    public void nameTest() {
        System.out.println(ClassTest.class.getName());
        System.out.println(ClassTest.class.getTypeName());
        // 不带包名
        System.out.println(ClassTest.class.getSimpleName());
    }

    /**
     * 把泛型的Class   转为指定类型的Class
     *
     * @throws Exception
     */
    @Test
    public void asSubclass() throws Exception {
        Class<?> aClass = Class.forName("com.kaka.jtest.jdk.model.Son");
        // 此时不知道具体的类型
        aClass.newInstance();
        // 使用使用asSubclas转换为具体的类型转换为具体的类型
        Class<? extends Father> asSubclass = aClass.asSubclass(Father.class);
        asSubclass.newInstance().fatherOneMethod();
    }

    /**
     * 判断是否是该Class下的实例
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void isInstance() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.kaka.jtest.jdk.model.Person");
        Person person = new Person();
        boolean instance = personClass.isInstance(person);
        System.out.println(instance);

    }
}
