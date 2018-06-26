package com.kaka.jtest.jdk8.lambda;

import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * lambda表达式
 *
 * @author shuangkaijia
 */
public class LambdaTest {

    /**
     * lambda语法
     */
    @Test
    public void grammar() {
        // 1.Lambda 表达式不包含参数，使用空括号 () 表示没有参数。
        Runnable noArguments = () -> System.out.println("Hello World");
        // 2.Lambda 表达式包含且只包含一个参数，可省略参数的括号
        ActionListener oneArgument = event -> System.out.println("button clicked");
        // 3.Lambda 表达式的主体可以写成一段代码块，需要使用大括号将代码块括起来
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };
        // 4.Lambda 表达式多个参数，变量add的类型是 BinaryOperator<Long>，它不是两个数字的和，而是将两个数字相加的那行代码。
        BinaryOperator<Long> add = (x, y) -> x + y;
        // 5.Lambda 表达式显式声明参数类型,需要使用小括号将参数括起来
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }

    /**
     * 1.设计匿名内部类的目的之一，就是为了方便将代码作为数据传递
     * 2.使用lambda无需指定参数的类型
     */
    @Test
    public void customLambda() {
        String name  = "5";
        this.executeAction((a, b) -> {System.out.println("执行一个Action..." + name);});
    }


    private void executeAction(ActionInterface actionInterface) {
        actionInterface.oneAction(5, 6);
    }
}