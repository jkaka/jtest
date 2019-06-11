package com.kaka.jtest.redis.controller;

import com.kaka.jtest.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/redisController")
public class RedisController {
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss SSS");

    @Autowired
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<Object, Object> redisTemplateObject;
    @Autowired
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<String, List<User>> redisTemplateUsers;

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
    @RequestMapping("/testSelect/{pattern}")
    public String testSelect(@PathVariable String pattern) {
        long startTime = System.currentTimeMillis();
        try {
            int sum = redisTemplate.keys(pattern).size();
            System.out.println("总数据：" + sum + "条");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keys*查询耗时：" + (endTime - startTime) + "ms");

        // 当要创建的匿名内部类包含泛型参数时，lambda表达式的参数需要指明类型，即内部类的具体类型
        int sum = redisTemplate.execute((RedisCallback<Set<Object>>) connection -> {
            Set<Object> binaryKeys = new HashSet<>();
            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match(pattern).count(10000).build());
            connection.close();
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
        redisTemplate.execute(connection -> {
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
    @RequestMapping("/insertBatchTest")
    public String insertBatchTest() {
        try {
            long startTime = System.currentTimeMillis();

            AtomicInteger num = new AtomicInteger(0);
            for(int i = 0; i < 100; i ++){
                new Thread(() ->{
                    for (; num.intValue() < 500000; ) {
                        int tmp = num.incrementAndGet();
                        redisTemplate.opsForValue().set("ota-task-upgrading-" + tmp, "Y");
                        System.out.println("插入数据:" + tmp);
                    }

                }).start();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime));
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
     * 存储方式跟序列化方式有关,跟泛型无关
     */
    @ResponseBody
    @RequestMapping("/setObjectAndString")
    public String setObjectAndString() {
        // 存储值一样
        redisTemplate.opsForValue().set("str", "ss");
        redisTemplateObject.opsForValue().set("objStr", "ss");

        // 存储值一样
        List<User> users = Collections.singletonList(new User(1));
        redisTemplateUsers.opsForValue().set("user", users);
        redisTemplateObject.opsForValue().set("objUser", users);

        Map<String, Object> properties = new HashMap<>();
        properties.put("123", "hello");
        properties.put("abc", "5");
        redisTemplate.opsForHash().putAll("hash", properties);
        Map<Object, Object> ans = redisTemplate.opsForHash().entries("hash");
        System.out.println("ans: " + ans);
        return "setObjectAndString";
    }

    @ResponseBody
    @RequestMapping("/setNx")
    public String setNx() {
        boolean lock = redisTemplateObject.opsForValue().setIfAbsent("jsk", "一个值");
        System.out.println("setIfAbsent加锁结果：" + lock);

        lock = redisTemplate.execute((RedisCallback<Boolean>) connection ->
                connection.setNX("jsk".getBytes(), "一个值".getBytes())
        );
        System.out.println("setNx加锁结果：" + lock);
        redisTemplate.delete("jsk");
        return "setObjectAndString";
    }

    @ResponseBody
    @RequestMapping("/delKey")
    public String delKey() {
        AtomicInteger num = new AtomicInteger(0);
        for(int i = 0; i < 100; i ++){
            new Thread(() ->{
                for (; num.intValue() < 800000; ) {
                    int tmp = num.incrementAndGet();
                    Boolean delete = redisTemplateObject.delete("ota-task-upgrading-" + num);
                    System.out.println("删除:" + tmp + ";status:" + delete);
                }

            }).start();
        }
        return "delKey";
    }
}
