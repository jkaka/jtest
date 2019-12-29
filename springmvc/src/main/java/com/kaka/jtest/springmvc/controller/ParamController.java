package com.kaka.jtest.springmvc.controller;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import com.oracle.tools.packager.mac.MacAppBundler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiashuangkai
 * @date 2019/12/16 21:49:21
 */
@RestController
@RequestMapping("/paramController")
public class ParamController {

    /**
     * name可以接收两个个地方的入参：
     * 1. uri上 /uriParam?name=jsk
     * 2. form-data格式的表单中：name=jsk001
     * 如果两个都存在，则会把1和2中的值拼接，以逗号分隔
     *
     * @param name
     * @return
     */
    @RequestMapping("/uriParam")
    public String uriParam(String name) {
        System.out.println(name);
        return name;
    }

    /**
     * body中raw类型的值，如果请求为空会报错
     * 1. 接收是String类型，则会把接收的值为json串
     * 2. 接收类型为Map（jsonObject）,则会把body中的json串序列化成Map对象
     * 注意：@RequestBody只能有一个
     *
     * @param name
     * @return
     */
    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String name, Map<String, String> param) {
        System.out.println(name);
        System.out.println(param);
        return name;
    }
}
