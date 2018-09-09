package com.kaka.jtest.jdk.java8.util;

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
     * of:得到对象的Optional容器
     */
    @Test
    public void of() {
        Optional<String> stringOptional = Optional.of("A");
        System.out.println(stringOptional);
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

    @Test
    public void emptyOptional() {
        // 创建空Optional对象
        Optional emptyOptional = Optional.empty();
        // 则可将一个空值转换成 Optional 对象
        Optional alsoEmpty = Optional.ofNullable(null);
        // isPresent:Optional 对象里是否有值
        System.out.println(emptyOptional.isPresent());
        System.out.println(alsoEmpty.isPresent());
    }

    /**
     * 使用 orElse 方法则更简洁，当 Optional 对象为空时，该方法提供了一个备选值。
     * 如果计算备选值在计算上太过繁琐，即可使用 orElseGet 方法。该方法接受一个Supplier 对象，只有在 Optional 对象真正为空时才会调用。
     * 如果默认值需要计算时,推荐使用orElseGet
     */
    @Test
    public void orElse() {
        Optional emptyOptional = Optional.empty();
        System.out.println(emptyOptional.orElse("testOrElse"));
        System.out.println(emptyOptional.orElseGet(() -> {
            System.out.println("当emptyOptional没有值时,才调用！");
            return "testOrElse";
        }));
    }
}
