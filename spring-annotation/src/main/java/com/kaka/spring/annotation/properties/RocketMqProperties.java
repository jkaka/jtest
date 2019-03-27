package com.kaka.spring.annotation.properties;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author: jsk
 * @date: 2019/3/13 17:21
 */
@Data
public class RocketMqProperties implements InitializingBean {
    private String rocketmqAddr;

    private String producerGroup;

    private String producerTopic;

    private String consumerGroup;

    private String consumerTopic;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("RocketMqProperties的afterPropertiesSet");
        consumerTopic = "test";
    }
}

