package com.kaka.jtest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: jsk
 * @date: 2019/4/18 14:12
 */
@RestController
@RequestMapping("/dataTypeController")
public class DataTypeController {
    @Autowired
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/hash_put")
    public String hashPut() {
        redisTemplate.opsForHash().put("hash001", "key001", "v1");
        redisTemplate.opsForHash().put("hash001", "key003", "v3");
        redisTemplate.opsForHash().put("hash001", "key002", "v2");
        return "hash_put";
    }

    @RequestMapping("/hash_get")
    public String hashGet() {
        System.out.println(redisTemplate.opsForHash().get("hash001", "key001"));
        System.out.println((Long) redisTemplate.opsForHash().get("hash001", "longType"));
        return "hash_get";
    }
}
