package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

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
            Thread.sleep(200);
        }
    }
}
