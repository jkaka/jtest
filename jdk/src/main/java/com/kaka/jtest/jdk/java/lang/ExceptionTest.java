package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author shuangkaijia
 */
public class ExceptionTest {

    /**
     * 测试嵌套的catch和finally
     */
    @Test
    public void testFinally() {
        try {
            try {
                int i = 0;
                if (i == 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("内层捕获到异常...");
            } finally {
                System.out.println("内层finally...");
            }
            return;
        } catch (Exception e) {
            // 内层没有throw异常，所以不走这里
            System.out.println("最外层捕获到异常...");
        } finally {
            System.out.println("最外层finally...");
        }
    }

    /**
     * 测试抛出其他类
     */
    public void testThrowOther() {
        // throw new Person();   只能抛出Throwable的子类
    }

    /**
     * 测试finally和return的执行顺序
     * 先发i的值准备返回，然后执行finally中的代码，此时要返回的值已经不会改变！
     */
    @Test
    public void testFinallyReturn() throws InterruptedException {
        System.out.println(testReturn());
    }

    private int testReturn() throws InterruptedException {
        int i = 0;
        try {
            return i;
        } catch (Exception e) {
            System.out.println("最外层捕获到异常...");
            return 2;
        } finally {
            System.out.println("最外层finally...");
            i = 3;
            Thread.sleep(2000);
            return i;
        }
    }

    /**
     * 输出异常类型名：错误信息
     */
    public void defaultToString() {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * 仅输出错误信息
     */
    @Test
    public void getMessage() {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 栈轨迹,默认输出到“标准错误流”：System.err
     */
    @Test
    public void printStackTrace() {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 栈轨迹输出到System.out
     */
    @Test
    public void printStackTrace2Out() {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Test
    public void printStackTrace2String() {
        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            StringWriter trace = new StringWriter();
            e.printStackTrace(new PrintWriter(trace));
            System.out.println(trace.toString());
        }
    }
}
