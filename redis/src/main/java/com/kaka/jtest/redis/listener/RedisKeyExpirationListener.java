package com.kaka.jtest.redis.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author jsk
 * @Date 2018/12/10 9:32
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对redis数据失效事件，进行数据处理
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取失效数据的key
        String expiredKey = message.toString();
        System.out.println(expiredKey + "过期了！");
        System.out.println(new String(pattern));
    }
}
