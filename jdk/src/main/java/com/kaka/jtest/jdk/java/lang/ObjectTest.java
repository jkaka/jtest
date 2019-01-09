package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.model.Person;
import com.kaka.jtest.jdk.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectTest {
    private static Student student = new Student();
    static {
        System.out.println("静态代码块...");
    }

    {
        person = new Person(1, "jsk");
        System.out.println("普通代码块...");
//        person.getId();
    }

    private Person person;
    public ObjectTest() {
        System.out.println("object...." + person.getId());
    }

    static void staticMethod() {
        System.out.println("staticMethod...");
    }

    /**
     * 创建对象执行顺序
     * 1.静态代码块和静态域，按声明顺序仅执行一次。
     * 2.代码块和非静态变量域，按声明顺序在对象每次创建之前执行。
     *      注意：如果非静态变量域,在代码块之后定义。代码块中可以初始化变量域,但不能调用变量域的方法；这样做可能没有意义，因为后面可能还会给变量域赋值。
     * 3.构造方法
     * 4.静态方法、普通方法在调用的时候才执行。
     *
     * 代码块和变量域执行顺序，跟声明顺序有关
     * 除了构造方法,其他方法都是在被调用时执行
     * 注意：构造方法中可以引用全局变量,跟声明顺序无关。是因为，构造方法执行的时候，变量域一定是已经执行完成了。
     *
     * @param args
     */
    public static void main(String[] args) {
        new ObjectTest();
        new ObjectTest();
    }

    /**
     * 赋值
     */
    @Test
    public void assignment(){
        List<Person> personList = new ArrayList<>();
        Person person = new Person("person");
        String string = "string";
        assignmntToList(personList, person, string);
        System.out.println(personList);
        System.out.println(person);
        System.out.println(string);
    }

    private void assignmntToList(List<Person> personList, Person person, String string){
        // personList指向了一个新的地址,原来地址中的内容未改变
        // 实参中引用地址值不会改变,所以assignment中的personList还是原来的值
        personList = Arrays.asList(new Person("AA"),
                new Person("BB"));
        // person指向了一个新的地址
        person = new Person("test");
        string = "abc";
    }
}
