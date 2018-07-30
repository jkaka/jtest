package com.kaka.jtest.redis.controller;

import com.kaka.jtest.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class RedisController {
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss SSS");

    @Autowired
    private RedisTemplate<String, Object> redisTemplateObject;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @ResponseBody
    @RequestMapping("/getKey")
    public String getKey() {
        redisTemplate.opsForValue().set("name1", new Date().toString());
        return redisTemplate.opsForValue().get("name1");
    }

    /**
     * 测试查询耗时时间
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/testSelect")
    public String testSelect() {
        long startTime = System.currentTimeMillis();
        try {
            int sum = redisTemplate.keys("A1*").size();
            System.out.println("总数据：" + sum + "条");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keys*查询耗时：" + (endTime - startTime) + "ms");

        // 当要创建的匿名内部类包含泛型参数时，lambda表达式的参数需要指明类型，即内部类的具体类型
        int sum = redisTemplate.execute((RedisCallback<Set<Object>>) connection -> {
            Set<Object> binaryKeys = new HashSet<>();
            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match("ota*").count(1000).build());
            while (cursor.hasNext()) {
                binaryKeys.add(new String(cursor.next()));
            }
            return binaryKeys;
        }).size();
        System.out.println("总数据：" + sum + "条");
        startTime = System.currentTimeMillis();
        System.out.println("cursor查询耗时：" + (startTime - endTime) + "ms");

        return "testSelect";
    }


    /**
     * 测试批量插入
     */
    @ResponseBody
    @RequestMapping("/insertBatch")
    public String insertBatch() {
        System.out.println("方式一：回调函数");
        long startTime = System.currentTimeMillis();
        redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            for (int i = 0; i < 500; i++) {
                byte[] key2 = serializer.serialize("A" + i);
                byte[] value2 = serializer.serialize("callBack");
                connection.set(key2, value2);
            }
            return true;
        }, false, true);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));

        try {
            System.out.println("方式二：循环connection");
            for (int i = 0; i < 500; i++) {
                redisTemplate.opsForValue().set("B" + i, "for");
            }
            startTime = System.currentTimeMillis();
            System.out.println("耗时：" + (startTime - endTime));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "insertBatch";
    }


    /**
     * 测试批量插入
     */
    @ResponseBody
    @RequestMapping("/insertByHash")
    public String insertByHash() {
        String key = "hashTest";
        Map map = new HashMap();
        map.put("DD", "11");
        map.put("BB", "99");
        map.put("CC", "33");
        redisTemplate.opsForHash().putAll(key, map);
        return "insertByHash";
    }

    /**
     * 测试设置过期时间
     * 时间不能为0
     */
    @ResponseBody
    @RequestMapping("/expire")
    public String expire() {
        Long time = null;
        redisTemplate.opsForValue().set("expire", "AAA", 5, TimeUnit.SECONDS);
        return "expire";
    }

    /**
     * 查看保存Object和String的区别
     */
    @ResponseBody
    @RequestMapping("/setObjectAndString")
    public String setObjectAndString() {
        List<User> users = Arrays.asList(new User(1));
        redisTemplateObject.opsForValue().set("string", "AAA");
        redisTemplateObject.opsForValue().set("object", users);
        return "setObjectAndString";
    }
}
