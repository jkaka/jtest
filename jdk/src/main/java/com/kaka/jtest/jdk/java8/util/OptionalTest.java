package com.kaka.jtest.jdk.java8.util;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * 在一个值可能为空的建模情况下，使用 Optional 对象能替代使用 null 值
 *
 * @author jsk
 * @Date 2018/8/15 14:16
 */
public class OptionalTest {

    /**
     * 创建空Optional对象
     */
    @Test
    public void emptyTest() {
        Optional emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        // isPresent:Optional 对象里是否有值
        System.out.println(emptyOptional.isPresent());
    }


    /**
     * of:得到对象的Optional容器
     * 当value值为空时，会报NullPointerException异常
     * 当value值不为空时，正常构造Optional对象
     */
    @Test
    public void of() {
        Optional<String> stringOptional = Optional.of("A");
        System.out.println(stringOptional);

        Optional<String> nullOptional = Optional.of(null);
        System.out.println(nullOptional);
    }

    /**
     * ofNullable：得到对象的Optional容器。
     * 支持空值得创建
     */
    @Test
    public void ofNullable() {
        // 则可将一个空值转换成 Optional 对象
        Optional alsoEmpty = Optional.ofNullable(null);
        System.out.println(alsoEmpty);
        System.out.println(alsoEmpty.isPresent());
    }


    /**
     * ifPresent：判断Optional中的value是否为空，不为空返回true
     */
    @Test
    public void isPresent() {
        Optional alsoEmpty = Optional.ofNullable(null);
        if (alsoEmpty.isPresent()) {
            System.out.println("对象不为空！");
        } else {
            System.out.println("对象为空");
        }
    }

    /**
     * ifPresent：Optional中的value不为空时,做的操作
     */
    @Test
    public void ifPresent() {
        Optional alsoEmpty = Optional.ofNullable(new Person(1, "AA"));
        alsoEmpty.ifPresent(System.out::println);
    }

    /**
     * get:从Optional容器中得到对象
     */
    @Test
    public void get() {
        Optional<String> stringOptional = Optional.of("A");
        System.out.println(stringOptional.get());


        // 先判断是否存在值
        stringOptional = Optional.ofNullable(null);
        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        } else {
            System.out.println("stringOptional中没有值！");
        }
    }

    /**
     * 使用 orElse 方法则更简洁，当 Optional 对象为空时，该方法提供了一个备选值。
     * 如果计算备选值在计算上太过繁琐，即可使用 orElseGet 方法。该方法接受一个Supplier 对象，只有在 Optional 对象真正为空时才会调用。
     * 如果默认值需要计算时,推荐使用orElseGet
     */
    @Test
    public void orElse() {
        Person person = Optional.of(new Person(1, "AA"))
                .orElse(new Person(1, "else"));
        System.out.println(person);

        person = Optional.of(new Person(1, "BB"))
                .orElseGet(() -> {
                    System.out.println("当emptyOptional没有值时,才调用！");
                    return new Person(1, "elseGet");
                });
        System.out.println(person);
    }

    @Test
    public void orElseThrow() throws Exception {
        Optional.of(null)
                .orElseThrow(Exception::new);
    }

    /**
     * 过滤值
     */
    @Test
    public void filterTest() {
        Optional<Person> optional = Optional.ofNullable(new Person(1, "AA"));
        Person person = optional.filter(p -> p.getName().equals("BB"))
                .orElse(new Person(1, "CC"));
        System.out.println(person);
    }

    /**
     * 转换值
     * map处理的参数为任意类型
     * flatMap处理的参数为Optional类型
     */
    @Test
    public void mapTest() {
        String name = Optional.ofNullable(new Person(1, "AA"))
                .map(Person::getName)
                .get();
        System.out.println(name);

        name = Optional.ofNullable(new Person(1, "BB"))
                .flatMap(person -> Optional.ofNullable(person.getName()))
                .get();
        System.out.println(name);
    }
}
