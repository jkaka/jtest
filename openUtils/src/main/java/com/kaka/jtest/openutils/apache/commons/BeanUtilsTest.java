package com.kaka.jtest.openutils.apache.commons;

import com.kaka.jtest.openutils.dataobject.CommonClass;
import com.kaka.jtest.openutils.dataobject.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * @author jsk
 * @Date 2018/10/26 17:07
 */
public class BeanUtilsTest {

    @Test
    public void copyPropertiesTest() throws Exception {
        Person person = new Person(1, "AA");
        int[] array = {1, 2, 3};

        CommonClass commonClass = new CommonClass();
        commonClass.setAge(5);
        commonClass.setBirthday(new Date());
        commonClass.setName("AA");
        commonClass.setPerson(person);
        commonClass.setArray(array);

        CommonClass commonClass2 = new CommonClass();
        BeanUtils.copyProperties(commonClass2, commonClass);
        System.out.println(commonClass2);
    }


    @Test
    public void performanceTest() throws Exception {
        Instant instant1 = Instant.now();
        for (int i = 0; i < 10000; i++) {
            copy();
        }
        Instant instant2 = Instant.now();
        for (int i = 0; i < 10000; i++) {
            set();
        }
        Instant instant3 = Instant.now();
        System.out.println(Duration.between(instant1, instant2).toMillis());
        System.out.println(Duration.between(instant2, instant3).toMillis());
    }

    private void copy() throws Exception {
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
