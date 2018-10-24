package com.kaka.jtest.openutils.spring.beans;

import com.kaka.jtest.openutils.dataobject.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author jsk
 * @Date 2018/10/23 19:48
 */
public class BeanUtilsTest {

    @Test
    public void copyProperties(){
        Person person1 = new Person(1, "AA");
        Person person2 = new Person(2, "BB");
        BeanUtils.copyProperties(person1, person2);
        System.out.println("person1:" + person1);
        System.out.println("person2:" + person2);
    }
}
