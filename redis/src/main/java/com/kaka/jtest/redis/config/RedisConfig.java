package com.kaka.jtest.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
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

    /*
    jedis连接池方式
    //    @Bean
    public RedisConnectionFactory redisConnectionFactory1() {
        // 1.设置Redis服务器参数
        JedisConnectionFactory connectionFactory = null;
        connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(properties.getProperty("spring.redis.host"));
        connectionFactory.setPort(Integer.valueOf(properties.getProperty("spring.redis.port")));
        connectionFactory.setDatabase(Integer.valueOf(properties.getProperty("spring.redis.database")));
        // 若Redis未设置密码，注释下面一行代码
        connectionFactory.setPassword(properties.getProperty("spring.redis.password"));
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
    }*/


    /**
     * 如果该工厂Bean交给spring管理,就不能显示调用afterPropertiesSet();否则会出现内存泄露问题:第二次调用afterPropertiesSet()会创建
     * 一个新的clientResources,之前的clientResources实例有可能被gc回收,但未调用clientResources.shutdown方法!
     *
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory cf = null;
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(properties.getProperty("spring.redis.host"));
        // 若Redis未设置密码，注释下面一行代码
        config.setPassword(RedisPassword.of(properties.getProperty("spring.redis.password")));
        config.setPort(Integer.valueOf(properties.getProperty("spring.redis.port")));
        config.setDatabase(Integer.valueOf(properties.getProperty("spring.redis.database")));

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(Integer.valueOf(properties.getProperty("spring.redis.pool.maxActive")));
        poolConfig.setMaxIdle(Integer.valueOf(properties.getProperty("spring.redis.pool.maxIdle")));
        poolConfig.setMinIdle(Integer.valueOf(properties.getProperty("spring.redis.pool.minIdle")));
        poolConfig.setMaxWaitMillis(Integer.valueOf(properties.getProperty("spring.redis.pool.maxWait")));

        LettucePoolingClientConfiguration poolingClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(poolConfig)
                .build();
        cf = new LettuceConnectionFactory(config, poolingClientConfiguration);
//        cf.afterPropertiesSet();
        return cf;
    }

    /**
     * Jackson2JsonRedisSerializer:序列化带泛型的数据时(List<User>)，会以map的结构(List<LinkedHashMap>)进行存储   1000条数据0.9s
     * 如果存放了List则在反系列化的时候如果没指定TypeReference则会报错java.util.LinkedHashMap cannot be cast to 。
     * <p>
     * GenericJackson2JsonRedisSerializer:会在序列化的json中加入@class属性，类的全路径包名，方便反系列化。    1000条数据1.5s
     * Generic(泛型)Jackson2JsonRedisSerializer效率略低
     *
     * @param redisConnectionFactory
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate jsonRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
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

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 原生序列化方式(jdk)
     *
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * key过期监听器
     *
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }
}