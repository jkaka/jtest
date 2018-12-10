package com.kaka.jtest.openutils.spring.beans;

import com.kaka.jtest.openutils.dataobject.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.time.Duration;
import java.time.Instant;

/**
 * @author jsk
 * @Date 2018/10/23 19:48
 */
public class BeanUtilsTest {

    @Test
    public void copyProperties() {
        Person person1 = new Person(1, "AA");
        Person person2 = new Person(2, "BB");
        BeanUtils.copyProperties(person1, person2);
        System.out.println("person1:" + person1);
        System.out.println("person2:" + person2);
    }

    private final Integer number = 1;

    @Test
    public void performanceTest() {
        Instant instant1 = Instant.now();
        for (int i = 0; i < number; i++) {
            copy();
        }
        Instant instant2 = Instant.now();
        for (int i = 0; i < number; i++) {
            set();
        }
        Instant instant3 = Instant.now();
        System.out.println("beanUtils copy " + number + "次,耗时：" + Duration.between(instant1, instant2).toMillis() + "ms");
        System.out.println("原生set方法" + number + "次,耗时：" + Duration.between(instant2, instant3).toMillis() + "ms");
    }

    private void copy() {
        // 从库中查询到DO
        Person person1 = new Person(1, "AA");
        // 新建DTO,并复制DO的值
        Person person2 = new Person();
        BeanUtils.copyProperties(person1, person2);
    }

    private void set() {
        Person person1 = new Person(1, "AA");
        Person person2 = new Person();

        person2.setId(person1.getId());
        person2.setName(person2.getName());
    }

}
