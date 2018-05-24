package com.kaka.jtest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RedisController {
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss SSS");
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ResponseBody
    @RequestMapping("/getKey")
    public String getKey(){
        redisTemplate.opsForValue().set("name1", new Date().toString());
        return redisTemplate.opsForValue().get("name1");
    }

    /**
     * 测试查询耗时时间
     * @return
     */
    @ResponseBody
    @RequestMapping("/testSelect")
    public String testSelect(){
        long startTime = System.currentTimeMillis();
        try {
            int sum = redisTemplate.keys("ota*").size();
            System.out.println("总数据：" + sum + "条");
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("查询耗时：" + (endTime - startTime) + "ms");
        return "testSelect";
    }
}
