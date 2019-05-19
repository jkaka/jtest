package com.kaka.jtest.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 对redis做连续的多个操作，这样的场景，网络传输的耗时将是限制redis处理量的主要瓶颈。
 * 那么此时就可以引入pipeline了，pipeline管道就是解决执行大量命令时、会产生大量传输次数而导致延迟的技术。
 *
 * @author: jsk
 * @date: 2019/5/8 16:17
 */
@RestController
@RequestMapping("/pipeLineController")
public class PipeLineController {

    @Autowired
    @Qualifier("jsonRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/execute")
    public String execute() {
        List<Object> List = redisTemplate.executePipelined(new RedisCallback<Long>() {
            @Nullable
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.openPipeline();
                for (int i = 0; i < 1000000; i++) {
                    String key = "123" + i;
                    connection.zCount(key.getBytes(), 0, Integer.MAX_VALUE);
                }
                return null;
            }
        });
        return "execute";
    }
}
