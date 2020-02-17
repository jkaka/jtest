package com.kaka.jtest.springmvc.controller;

import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import com.kaka.jtest.springmvc.dataobject.User;
import com.oracle.tools.packager.mac.MacAppBundler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 注意：如果不使用@RequestBody参数来接收Date类型的数据，传入格式必须为yyyy/MM/dd HH:mm:ss；使用时间戳传入，会解析错误！
     * 因为底层使用的是Date.parse(String)方法
     *
     * @param name
     * @return
     */
    @RequestMapping("/uriParam")
    public String uriParam(String name, Date date) {
        System.out.println(name);
        System.out.println(date);
        return name;
    }

    /**
     * body中raw类型的值，如果请求为空会报错
     * 1. body中的内容由@RequestBody后面的参数接收
     * 2. 接收参数类型为Map（jsonObject）,则会把body中的json串序列化成Map对象
     * 注意：@RequestBody只能有一个
     *
     * @param name
     * @return
     */
    @RequestMapping("/requestBody")
    public String requestBody(String name, @RequestBody Map<String, String> param) {
        System.out.println(name);
        System.out.println(param);
        return name;
    }

    /**
     * 接收日期类型
     * 支持时间戳
     */
    @ResponseBody
    @RequestMapping("/dateParam")
    public User dateParam(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
