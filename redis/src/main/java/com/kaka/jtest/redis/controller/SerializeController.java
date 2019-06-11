package com.kaka.jtest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: jsk
 * @date: 2019/6/3 15:11
 */
@Controller
@RequestMapping("/serializeController")
public class SerializeController {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @ResponseBody
    @RequestMapping("/setString")
    public String setString() {
        // 默认jdk序列化方式
        redisTemplate.opsForValue().set("a1", "v");
        // string序列化方式
        redisTemplate.execute((RedisCallback<Boolean>) connection ->
                connection.set("a2".getBytes(), "v".getBytes())
        );
        return "setString";
    }

    @ResponseBody
    @RequestMapping("/getString")
    public String getString() {
        // 默认jdk序列化方式
        Object string = redisTemplate.opsForValue().get("a1");
        System.out.println("jdk序列化方式得到a1：" + string);
        string = redisTemplate.opsForValue().get("a2");
        System.out.println("jdk序列化方式得到a2：" + string);

        // string序列化方式
        string = redisTemplate.execute((RedisCallback<Object>) connection ->
                connection.get("a1".getBytes())
        );
        System.out.println("string序列化方式得到a1：" + string);
        string = redisTemplate.execute((RedisCallback<Object>) connection ->
                connection.get("a2".getBytes())
        );
        System.out.println("string序列化方式得到a2：" + string);
        System.out.println("string序列化方式得到a2(反序列化)：" + new String((byte[]) string));
        return "setString";
    }

    @ResponseBody
    @RequestMapping("/setHash")
    public String setHash() {
        // 默认jdk序列化方式
        redisTemplate.opsForHash().put("hash001", "key001", "v");
        // string序列化方式
        redisTemplate.execute((RedisCallback<Boolean>) connection ->
                connection.hSet("hash002".getBytes(), "key001".getBytes(), "v".getBytes())
        );
        return "setHash";
    }
}
