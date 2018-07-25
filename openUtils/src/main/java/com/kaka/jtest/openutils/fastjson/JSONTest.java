package com.kaka.jtest.openutils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class JSONTest {
    /**
     * json字符串转JSONObject对象
     */
    @Test
    public void parseObject() {
        String json = "{\"dubbo\":\"group001\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        String str = jsonObject.getString("dubbo");
        System.out.println(str);
    }
}
