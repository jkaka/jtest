package com.kaka.jtest.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaka.jtest.redis.listener.RedisKeyExpirationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author shuangkaijia
 */
@Configuration
public class RedisConfig {
    private Properties properties;

    {
        properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream("/redis.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 1.设置Redis服务器参数
        JedisConnectionFactory connectionFactory = null;
        connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(properties.getProperty("spring.redis.host"));
        connectionFactory.setPort(Integer.valueOf(properties.getProperty("spring.redis.port")));
        connectionFactory.setDatabase(Integer.valueOf(properties.getProperty("spring.redis.database")));
        // 若Redis未设置密码，注释下面一行代码
//        connectionFactory.setPassword(properties.getProperty("spring.redis.password"));
        connectionFactory.setTimeout(Integer.valueOf(properties.getProperty("spring.redis.timeout")));

        // 2.设置Redis连接池参数
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(Integer.valueOf(properties.getProperty("spring.redis.pool.maxActive")));
        poolConfig.setMaxWaitMillis(Integer.valueOf(properties.getProperty("spring.redis.pool.maxWait")));
        poolConfig.setMaxIdle(Integer.valueOf(properties.getProperty("spring.redis.pool.maxIdle")));
        poolConfig.setMinIdle(Integer.valueOf(properties.getProperty("spring.redis.pool.minIdle")));
        poolConfig.setSoftMinEvictableIdleTimeMillis(Integer.valueOf(properties.getProperty("spring.redis.port")));
        connectionFactory.setPoolConfig(poolConfig);
        connectionFactory.afterPropertiesSet();
        return connectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
//        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory());
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        // 注意：objectMapper是databind包中的类
        ObjectMapper objectMapper = new ObjectMapper();
        // 注意：JsonAutoDetect是annotation包中的类
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());
        return container;
    }
}