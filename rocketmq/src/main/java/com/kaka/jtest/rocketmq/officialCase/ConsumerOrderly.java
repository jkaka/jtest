package com.kaka.jtest.rocketmq.officialCase;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author: jsk
 * @date: 2019/9/11 10:51
 */
public class ConsumerOrderly {
    private final static String TOPIC = "jsk-test-rocketmq";

    public static void main(String[] args) throws InterruptedException, MQClientException {


        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("jsk_group");

        // Specify name server addresses.
//        consumer.setNamesrvAddr("test01.cdh.ecarx.local:9876;test02.cdh.ecarx.local:9876");
        consumer.setNamesrvAddr("dev.cdh.ecarx.local:9876");

//         Subscribe one more more topics to consume.
        consumer.subscribe(TOPIC, "OWNERDRIVER");

        consumer.setConsumeMessageBatchMaxSize(1);

        /**
         * 最大重试次数
         */
        consumer.setMaxReconsumeTimes(5);

        /**
         * 重复消费的时间间隔
         */
        consumer.setSuspendCurrentQueueTimeMillis(5000);
        /**
         * 有序消息
         * 1. 一个线程对应一个队列
         * 2. 重试的消息不会进入重试队列
         */
        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs,
                                                       ConsumeOrderlyContext context) {
                System.out.printf(TOPIC + "：%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                System.out.println("\n" + msgs.size());
                System.out.println("重试次数:" + msgs.get(0).getReconsumeTimes());
                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
        });

        //Launch the consumer instance.
        consumer.start();
        System.out.printf("Consumer Started.%n");

    }
}
