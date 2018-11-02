package com.kaka.jtest.openutils.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.openutils.dataobject.Person;
import com.kaka.jtest.openutils.dataobject.Student;
import org.junit.Test;

import java.util.*;

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
     * json字符串转map
     * parseObject(jsonStr); 返回值只能是Map<String, Object>
     * parseObject(jsonStr, Map.class);
     */
    @Test
    public void json2Map() {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "AA"), new Person(2, "BB")));
        Map<String, String> map = new HashMap<>();
        map.put("insertList", JSONObject.toJSONString(personList));
        System.out.println("原生toString() : " + map);
        String jsonStr = JSONObject.toJSONString(map);
        System.out.println("fastJson的toString() : " + jsonStr);

        Map<String, Object> map1 = JSONObject.parseObject(jsonStr);
        System.out.println("未指定class时,toString：" + map1);
        System.out.println(map1.get("insertList"));

        Map<String, Object> map2 = JSONObject.parseObject(jsonStr, Map.class);
        System.out.println("指定class时,toString与java原生的一样：" + map2);
        System.out.println(map2.get("insertList"));
    }

    /**
     * json字符串转List
     */
    @Test
    public void json2List() {
        List<String> labelIds = Arrays.asList("AA", "bb");
        String labelIdsJson = JSONObject.toJSONString(labelIds);
        labelIds = JSONObject.parseObject(labelIdsJson, List.class);
        System.out.println(labelIds);
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
     * 从jsonObject中获取JSONArray
     * 如果key不存在时,JSONArray的值返回null
     */
    @Test
    public void getJSONArray() {
        JSONObject jsonObject = new JSONObject();
        JSONArray matCodeJson = jsonObject.getJSONArray("matCodeList");
        List<String> matCodeList = matCodeJson.toJavaList(String.class);
        System.out.println(matCodeJson);
        System.out.println(matCodeList);
    }

    /**
     * json字符串转JSONObject对象
     */
    @Test
    public void parseObject() {
        String json = "{\"dubbo\":\"group001\"}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        String str = jsonObject.getString("dubbo");
        System.out.println(str);
    }

    @Test
    public void toJSONString() {
        String[] strings = {"aa", "bb"};
        System.out.println(JSONObject.toJSONString(strings));
    }

}
