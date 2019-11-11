package com.kaka.jtest.openutils.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.kaka.jtest.openutils.beans.*;
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
        student.setAge(null);
        String studentJson = JSONObject.toJSONString(student);
        System.out.println(studentJson);
        Person person = JSONObject.parseObject(studentJson, Person.class);
        System.out.println(person);
    }


    /**
     * 泛型
     */
    @Test
    public void type() {
        Map<String, String> map = new HashMap<String, String>(8) {{
            put("name1", "AA");
            put("name2", "BB");
        }};
        System.out.println(map);

        String json = JSONObject.toJSONString(map);
        Map<String, String> map1 = JSONObject.parseObject(json, new TypeReference<Map<String, String>>() {
        });
        System.out.println(map1);
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
     * 得到jsonObject中key对应的value，如果key不存在时返回null 不会报错
     */
    @Test
    public void getString() {
        JSONObject jsonObject = new JSONObject();
        String matCode = jsonObject.getString("matCode");
        System.out.println(matCode);
    }

    @Test
    public void getBoolean() {
        JSONObject jsonObject = new JSONObject();
        Boolean matCode = jsonObject.getBoolean("matCode");
        System.out.println(matCode);
        if (matCode) {
            System.out.println("**************");
        }
    }

    @Test
    public void getDouble(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value", 4.46979288E8);
        Double value = jsonObject.getDouble("value");
        System.out.println(value);
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
        String json = "{\"name\":\"group001\"}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        String str = jsonObject.getString("dubbo");
        System.out.println(str);
    }

    /**
     * json字符串转指定类
     */
    @Test
    public void parseObject2Class() {
        String json = "{\"name\":\"group001\",\"gmtCreate\":\"2019-07-18 18:24:05\"}";
        DateObj dateObj = JSONObject.parseObject(json, DateObj.class);
        System.out.println(JSONObject.toJSONString(dateObj));
    }

    /**
     * json可以为null
     */
    @Test
    public void parseObjectNull() {
        Map<String, Object> featuresMap = (Map<String, Object>) JSONObject.parse(null);
        System.out.println(featuresMap);
    }


    /**
     * 对象转json字符串
     */
    @Test
    public void toJSONString() {
        // 1.数组转json
        String[] strings = {"aa", "bb"};
        System.out.println(JSONObject.toJSONString(strings));

        // 2.对象转json
        Person person = new Person(1, "aa");
        System.out.println(JSONObject.toJSONString(person));

        // 3.解析json串
        String json = "{\"id\":1,\"name\":\"aa\"}";
        System.out.println(JSONObject.parseObject(json, Person.class));

        // 4.json串转json
        System.out.println(JSONObject.toJSONString(json));

        // 5.map转 json
        Map<String, String> map = new HashMap<>(8);
        map.put("id", "99");
        map.put("name", "jsk");
        System.out.println(map);
        System.out.println(JSONObject.toJSONString(map));
    }

    /**
     * 通过对象中的getter方法来取对应field值,进而转成json串
     */
    @Test
    public void toJSONStringMapParam() {
        Map<String, String> param = new HashMap<>(8);
        param.put("aa", "aa");
        FiledTwoObject filedTwoObject = new FiledTwoObject();
        filedTwoObject.setMapParam(param);

        FiledObject person = new FiledObject();
        person.setId(8);
        person.setFiledTwoObject(filedTwoObject);
        System.out.println(JSONObject.toJSONString(person));
    }

    /**
     * put进来的object会自动转json
     */
    @Test
    public void putTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ecuInventory", new Person(1, "AA"));
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void empty(){
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.isEmpty());
        System.out.println(jsonObject);
    }

    @Test
    public void keySet(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key001", "value");
        jsonObject.put("key002", "value");
        System.out.println(jsonObject.keySet());
    }

    @Test
    public void containsKey(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key001", "value");
        jsonObject.put("key002", "value");
        System.out.println(jsonObject.containsKey("key001"));
    }

    @Test
    public void getInteger(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key001", "value");
        int num = jsonObject.getInteger("a");
        System.out.println(num);
    }

    @Test
    public void getIntValue(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key001", "value");
        int num = jsonObject.getIntValue("a");
        System.out.println(num);
    }
}
