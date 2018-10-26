package com.kaka.jtest.openutils.apache.commons;

import com.kaka.jtest.openutils.dataobject.CommonClass;
import com.kaka.jtest.openutils.dataobject.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author jsk
 * @Date 2018/10/26 17:07
 */
public class BeanUtilsTest {

    @Test
    public void copyPropertiesTest(){
        Person person = new Person(1, "AA");
        int[] array = {1, 2, 3};

        CommonClass commonClass = new CommonClass();
        commonClass.setAge(5);
        commonClass.setBirthday(new Date());
        commonClass.setName("AA");
        commonClass.setPerson(person);
        commonClass.setArray(array);

        CommonClass commonClass2 = new CommonClass();
        BeanUtils.copyProperties(commonClass, commonClass2);
        System.out.println(commonClass2);
    }
}
