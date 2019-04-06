package com.kaka.jtest.jdk.java.lang.instrument;

/**
 * @author: jsk
 * @date: 2019/4/3 14:17
 */
public class MyAgentMain {
    /**
     * java -javaagent:your_agent_jar1=parameter1 -javaagent:your_agent_jar2=parameter2 -jar:your_jar
     * -javaagent:E:\workspace\myProject\jtest\jdk\src\main\java\com\kaka\jtest\jdk\java\lang\instrument\jdk-1.0-SNAPSHOT.jar=Hello1 -javaagent:E:\workspace\myProject\jtest\jdk\src\main\java\com\kaka\jtest\jdk\java\lang\instrument\jdk-1.0-SNAPSHOT.jar=Hello2
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("*************主函数");
    }
}
