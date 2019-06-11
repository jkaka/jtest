package com.kaka.jtest.openutils.javassist;

import com.kaka.jtest.openutils.beans.Person;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/6/3 9:38
 */
public class CtMethodTest {
    @Test
    public void insertCodeTest() throws Exception {
        CtClass ctClass = ClassPool.getDefault().get("com.kaka.jtest.openutils.beans.Person");

        CtMethod sayHelloMethod = ctClass.getDeclaredMethod("sayHello");

        sayHelloMethod.insertBefore("System.out.println(\"before sayHello----\");");

        sayHelloMethod.insertAfter("System.out.println(\"after sayHello----\");");
        Person person = (Person) ctClass.toClass().newInstance();
        person.sayHello();
    }
}
