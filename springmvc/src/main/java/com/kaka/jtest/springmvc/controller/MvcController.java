package com.kaka.jtest.springmvc.controller;

import com.alibaba.fastjson.JSONObject;

import com.kaka.jtest.springmvc.dataobject.Order;
import org.springframework.web.bind.annotation.*;

/**
 * @author shuangkaijia
 */
@RestController
@RequestMapping("/mvcController")
public class MvcController {

    /**
     * fastjson的JSONObject对象可以接收键值对，并且可以把值转换为需要的类型
     * name接收的是URI上的参数
     *
     * @param name
     * @param jsonObject
     * @return
     */
    @RequestMapping("/testJSONObject")
    public String testJSONObject(String name, @RequestBody JSONObject jsonObject) {
        System.out.println("name:" + name);
        System.out.println(jsonObject);
        Integer age = jsonObject.getInteger("age");
        System.out.println("age" + age);
        return "testJSONObject";
    }

    /**
     * 如果传{}  order中的属性,除了基本类型其他都是null({}就代表order对象被初始化)
     * 如果传{ "goods":{} }  order中的goods对象属性被初始化
     *
     * @param order
     * @return
     */
    @RequestMapping("/objWrapObj")
    public String objWrapObj(@RequestBody Order order) {
        System.out.println(order);
        return "objWrapObj";
    }

    /**
     * 支持中间带点的参数
     *
     * @param name
     * @return
     */
    @GetMapping("/test/{name:.+}")
    public String test(@PathVariable String name) {
        System.out.println(name);
        return "objWrapObj";
    }
}
