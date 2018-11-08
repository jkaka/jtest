package com.kaka.jtest.jdk.java8.lambda.method;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 方法引用
 *
 * @author jsk
 * @Date 2018/8/22 9:54
 */
public class MethodTest {

    /**
     * 方法引用：当需要引用方法的第一个参数是调用对象，并且第二个参数是需要引用方法的第二个参数(或无参数)时：ClassName::methodName
     * person -> person.getName()   等于  Person::getName
     * (person, name) -> person.getAgeByName(name)  等于  Person::getAgeByName
     */
    @Test
    public void methodQuote() {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "aa"), new Person(2, "bb")));
        List<String> personNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(personNames);

        //对象的引用 :: 实例方法名
        Consumer<String> consumer = str -> System.out.println(str);
        Consumer<String> consumerMethodQuote = System.out::println;

        Person jsk = new Person("jsk");
        Supplier<String> supplier = () -> jsk.getName();
        Supplier<String> supplierMethodQuote = jsk::getName;

        // 类名 :: 静态方法名
        BiFunction<Double, Double, Double> biFunction1 = (x, y) -> Math.pow(x, y);
        BiFunction<Double, Double, Double> biFunctionMethodQuote1 = Math::pow;

        // 类名 :: 实例方法名
        Function<Person, String> function = Person::getName;
        Function<Person, String> functionMethodQuote = Person::getName;

        BiFunction<Person, String, Integer> biFunction = (person, name) -> person.getAgeByName(name);
        BiFunction<Person, String, Integer> biFunctionMethodQuote = Person::getAgeByName;

    }

    /**
     * 构造器引用
     */
    @Test
    public void newObj() {
        testLambdaNew((id, name) -> new Person(id, name));
        testLambdaNew(Person::new);

        // 发现这个function和stream中的map有点像
        Function<String, Person> function = Person::new;
    }

    private void testLambdaNew(LambdaNewObj lambdaNewObj) {
        lambdaNewObj.create(1, "aa");
    }


    /**
     * 数组引用
     */
    @Test
    public void newArray() {
        testLambdaNewArray(length -> new Person[length]);
        testLambdaNewArray(Person[]::new);

        Function<Integer, Integer[]> function = n -> new Integer[n];
        Function<Integer, Integer[]> functionArrayQuote = Integer[]::new;
    }

    private void testLambdaNewArray(LambdaNewArray lambdaNewArray) {
        lambdaNewArray.create(5);
    }

}
