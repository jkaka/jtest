package com.kaka.jtest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class RedisController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ResponseBody
    @RequestMapping("/getKey")
    public String getKey(){
        redisTemplate.opsForValue().set("name1", new Date().toString());
        return redisTemplate.opsForValue().get("name1");
    }
}
