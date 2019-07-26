package com.kaka.jtest.jdk.java.lang.reflect;

import com.kaka.jtest.jdk.model.ReflectObject;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author: jsk
 * @date: 2019/7/2 16:37
 */
public class FieldTest {

    /**
     * 修改final+static的filed值
     */
    @Test
    public void finalWithStatic() throws Exception {
        System.out.println(ReflectObject.getTestStr());

        // 1.获取strField
        Field strField = ReflectObject.class.getDeclaredField("testStr");
        strField.setAccessible(true);

        // 2.把strField的final修饰符去掉:
        Field modifiers = strField.getClass().getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(strField, strField.getModifiers() & ~Modifier.FINAL);

        // 3.设置值
        ReflectObject reflectObject = new ReflectObject();
        strField.set(reflectObject, "bb");

        // 4.再把final修饰符加回来
        modifiers.setInt(strField, strField.getModifiers() & ~Modifier.FINAL);
        System.out.println(ReflectObject.getTestStr());
    }
}
