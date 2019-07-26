package com.kaka.jtest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/str2Hash")
    public String str2Hash() {
        redisTemplate.opsForValue().set("test", "test001");
        // 本来存的是k-v,再存k-hash的时候就会报  命令执行异常
        redisTemplate.opsForHash().put("test", "545", "test001");
        System.out.println(redisTemplate.opsForValue().get("test"));
        System.out.println(redisTemplate.opsForHash().get("test", "545"));
        return "str2Hash";
    }
}
