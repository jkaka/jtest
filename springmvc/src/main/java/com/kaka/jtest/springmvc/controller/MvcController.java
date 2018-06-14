package com.kaka.jtest.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author shuangkaijia
 */
@Controller
public class MvcController {

    /**
     * fastjson的JSONObject对象可以接收键值对，并且可以把值转换为需要的类型
     * @param name
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJSONObject")
    public String testJSONObject(String name, @RequestBody JSONObject jsonObject) {
        System.out.println(name);
        System.out.println(jsonObject);
        Integer age = jsonObject.getInteger("age");
        System.out.println(age);
        return "testJSONObject";
    }

}
