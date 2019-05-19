package com.kaka.jtest.jdk.java.lang;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author: jsk
 * @date: 2019/4/16 9:50
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        MyClassLoader myClassLoader = new MyClassLoader();
        MyClassLoader myClassLoader1 = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass(APP.class.getName());
        Class<?> aClass1 = myClassLoader1.loadClass(APP.class.getName());

        System.out.println(aClass == aClass1);

        Class<?> defaultClass = Class.forName("com.kaka.jtest.jdk.java.lang.APP");
        System.out.println(defaultClass == aClass1);

        URL[] urls = {new URL("http://www.runoob.com/index.html?language=cn#j2se")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls, ClassLoader.class.getClassLoader());
    }

    static class MyClassLoader extends ClassLoader{
    }
}

