package com.kaka.jtest.jdk.java.grammar;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

public class SwitchTest {

    /**
     * switch中有return  此方法结束
     */
    @Test
    public void switchTest() {
        String requestType = "serviceRequest";
        returnTest(requestType);
    }

    private void returnTest(String requestType) {
        switch (requestType) {
            case "ack":
                System.out.println("ack");
                return;
            case "serviceRequest":
                System.out.println("serviceRequest");
                break;
            default:
                System.out.println("requestType请求类型不正确");
        }

        System.out.println("前面有return  是否还能输出");
    }

    /**
     * 多个case合起来为一个作用域
     */
    @Test
    public void scopeTest() {
        String requestType = "serviceRequest";
        switch (requestType) {
            case "ack":
                // 只是定义,走到这个分支时才真正创建person
                // 但这个定义的变量可以被其他case使用
                Person person = new Person("AA");
                System.out.println(person);
                break;
            case "serviceRequest":
                person = new Person("BB");
                System.out.println(person);
                break;
            default:
                System.out.println("requestType请求类型不正确");
        }
    }

}
