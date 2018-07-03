package com.kaka.jtest.tools.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.tools.fastjson.dataobject.Person;
import com.kaka.jtest.tools.fastjson.dataobject.Student;
import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class JSONObjectTest {
    /**
     * 少属性的对象转换为多个属性的对象
     */
    @Test
    public void parseObjectS2M(){
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
    public void parseObjectM2S(){
        Student student = new Student();
        student.setId(10);
        student.setName("student");
        student.setClassId(9);
        String studentJson = JSONObject.toJSONString(student);
        System.out.println(studentJson);
        Person person = JSONObject.parseObject(studentJson, Person.class);
        System.out.println(person);
    }
}
