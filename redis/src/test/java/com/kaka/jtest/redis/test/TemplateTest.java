package com.kaka.jtest.redis.test;

import com.kaka.jtest.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class TemplateTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("name1", "AA");
        System.out.println(redisTemplate.opsForValue().get("name1"));

    }
}
