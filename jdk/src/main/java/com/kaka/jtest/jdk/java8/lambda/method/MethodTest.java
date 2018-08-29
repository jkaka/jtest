package com.kaka.jtest.jdk.java8.lambda.method;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 方法引用
 *
 * @author jsk
 * @Date 2018/8/22 9:54
 */
public class MethodTest {

    /**
     * 方法引用
     * artist -> artist.getName()  的简写 Artist::getName
     */
    @Test
    public void methodQuote() {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "aa"), new Person(2, "bb")));
        List<String> personNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(personNames);
    }

    /**
     * lambda创建对象
     */
    @Test
    public void newObj(){
        testLambdaNew((id ,name) -> new Person(id ,name));
        testLambdaNew(Person::new);
    }

    private void testLambdaNew(LambdaNewObj lambdaNewObj){
        lambdaNewObj.create(1,"aa");
    }


    /**
     * lambda创建对象数组(大小)
     */
    @Test
    public void newArray(){
        testLambdaNewArray(length -> new Person[length]);
        testLambdaNewArray(Person[] :: new);
    }

    private void testLambdaNewArray(LambdaNewArray lambdaNewArray){
        lambdaNewArray.create(5);
    }

}
