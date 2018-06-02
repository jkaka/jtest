package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.java.lang.entities.Person;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testFinally() {
        try {
            try {
                int i = 0;
                if (i == 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("----");
            } finally {
                System.out.println("finally");
            }
        } catch (Exception e) {
            System.out.println("最外层exception");
        } finally {
            System.out.println("最外层finally");
        }
    }

    public void throwTest(){

        // throw new Person();   只能抛出Throwable的子类
    }
}
