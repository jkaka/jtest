package com.kaka.jtest.openutils.json;

import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.openutils.beans.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APP {

    @Test
    public void test(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "AA"));
        personList.add(new Person(2, "BB"));
        Map<String,String> map=new HashMap<>();
        map.put("insertList", JSONObject.toJSONString(personList));
        String jsonStr = JSONObject.toJSONString(map);
        System.out.println(jsonStr);
        Map<String,String> map1 = JSONObject.parseObject(jsonStr, Map.class);
        System.out.println(map1);
    }
}
