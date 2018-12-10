package com.kaka.jtest.rocketmq.beanconfig;

import com.kaka.common.utils.LogUtil;
import com.kaka.jtest.rocketmq.listener.RocketConsumeMsgListenerProcessor;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jsk
 * @Date 2018/11/29 15:17
 */
@Configuration
public class RocketMQBeanConfig {
    private LogUtil logger = new LogUtil("jsk");

    private String namesrvAddr = "10.43.100.169:9876";

    private String producerGroup = "producer001";
    private String consumerGroup = "consumer001";

    private String topics = "topic_jsk001;topic_jsk002";

    /**
     * rocket MQ 生产者
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer getRocketMQProducer() throws MQClientException {

        DefaultMQProducer producer;
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        //如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
        //producer.setInstanceName(instanceName);
        //消息最大长度 默认1024*4(4M)
        producer.setMaxMessageSize(4096);
        // 发送消息超时时间,默认3000ms
        producer.setSendMsgTimeout(3000);
        //如果发送消息失败，设置重试次数，默认为2次
        producer.setRetryTimesWhenSendFailed(2);

        try {
            producer.start();
            logger.info(String.format("producer启动成功! groupName:[%s],namesrvAddr:[%s]", producerGroup, namesrvAddr));
        } catch (MQClientException e) {
            logger.error(String.format("producer is error {%s}", e.getMessage(), e));
            throw new MQClientException("生产者启动失败！", e);
        }
        return producer;
    }


    /**
     * rocket MQ 消费者
     *
     * @param rocketConsumeMsgListenerProcessor
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer(RocketConsumeMsgListenerProcessor rocketConsumeMsgListenerProcessor) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer");
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(20);
        consumer.setConsumeThreadMax(64);
        consumer.registerMessageListener(rocketConsumeMsgListenerProcessor);
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        /**
         * 设置消费模型，集群还是广播，默认为集群
         */
        //consumer.setMessageModel(MessageModel.CLUSTERING);
        /**
         * 设置一次消费消息的条数，默认为1条
         */
        consumer.setConsumeMessageBatchMaxSize(1);
        try {
            /**
             * 设置该消费者订阅的主题和tag，如果是订阅该主题下的所有tag，则tag使用*；如果需要指定订阅该主题下的某些tag，则使用||分割，例如tag1||tag2||tag3
             */
            String[] topicTagsArr = topics.split(";");
            for (String topicTags : topicTagsArr) {
                String[] topicTag = topicTags.split("~");
//                consumer.subscribe(topicTag[0], topicTag[1]);
                consumer.subscribe(topicTag[0], "tag01");
            }
            consumer.start();
            logger.info(String.format("rocketMQ消费者启动成功 !!! groupName:{%s},topics:{%s},namesrvAddr:{%s}",
                    consumerGroup, topics, namesrvAddr));
        } catch (MQClientException e) {
            logger.info(String.format("rocketMQ消费者启动失败 !!! groupName:{%s},topics:{%s},namesrvAddr:{%s}",
                    consumerGroup, topics, namesrvAddr));
            throw new MQClientException("消费者启动失败！", e);
        }
        return consumer;
    }
}
