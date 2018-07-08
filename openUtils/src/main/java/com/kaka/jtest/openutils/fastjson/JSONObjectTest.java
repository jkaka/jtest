package com.kaka.jtest.openutils.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.openutils.dataobject.Person;
import com.kaka.jtest.openutils.dataobject.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shuangkaijia
 */
public class JSONObjectTest {
    /**
     * 少属性的对象转换为多个属性的对象
     */
    @Test
    public void parseObjectS2M() {
        Person person = new Person();
        person.setId(10);
        person.setName("person");
        String personJson = JSONObject.toJSONString(person);
        System.out.println(personJson);
        Student student = JSONObject.parseObject(personJson, Student.class);
        System.out.println(student);
    }

    /**
     * 多个属性的对象转换为少属性的对象
     */
    @Test
    public void parseObjectM2S() {
        Student student = new Student();
        student.setId(10);
        student.setName("student");
        student.setClassId(9);
        String studentJson = JSONObject.toJSONString(student);
        System.out.println(studentJson);
        Person person = JSONObject.parseObject(studentJson, Person.class);
        System.out.println(person);
    }

    /**
     * json串转map
     */
    @Test
    public void test() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "AA"));
        personList.add(new Person(2, "BB"));
        Map<String, String> map = new HashMap<>();
        map.put("insertList", JSONObject.toJSONString(personList));
        String jsonStr = JSONObject.toJSONString(map);
        System.out.println(jsonStr);
        Map<String, String> map1 = JSONObject.parseObject(jsonStr, Map.class);
        System.out.println(map1);
    }

    /**
     * 得到jsonObject中key对应的value，如果key不存在时返回null
     */
    @Test
    public void getString() {
        JSONObject jsonObject = new JSONObject();
        String matCode = jsonObject.getString("matCode");
        System.out.println(matCode);
    }

    /**
     * 根据key得到JSONArray，如果key不存在时返回null
     */
    @Test
    public void getJSONArray() {
        JSONObject jsonObject = new JSONObject();
        JSONArray matCodeJson = jsonObject.getJSONArray("matCodeList");
        List<String> matCodeList = matCodeJson.toJavaList(String.class);
        System.out.println(matCodeJson);
    }


}
