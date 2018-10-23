package com.kaka.jtest.openutils.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.openutils.dataobject.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author jsk
 * @Date 2018/10/16 19:44
 */
public class JSONArrayTest {

    @Test
    public void parseArrayTest(){
        // 1.convert the list to a json string
        // 把list转为json字符串
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "AA"), new Person(2, "BB")));
        String listJson = JSONObject.toJSONString(personList);

        // 2. convert the json string to the list object
        // 把json字符串转为list对象
        List<Person> people = JSONArray.parseArray(listJson, Person.class);
        System.out.println(people);
    }

}
