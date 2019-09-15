package com.kaka.jtest.rocketmq.officialCase;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 一、同一个消费group中,多个consumer实例订阅了不同的topic
 * 1.consumer定时发送心跳，包含topic、group信息
 * 2.group以这个consumer发来的topic为准，（如果有变化）移除或增加topic
 * 3.获取topic对应的队列，分配给group下所有的consumer(真正订阅队列成功的是,订阅了该topic的consumer)
 * <p>
 * 前提：AB订阅topic1;C订阅topic2
 * 现象：一段时间由AB两个consumer订阅2/3的topic1分区,一段时间由C消费者订阅1/3的topic2分区
 *
 * @author jsk
 * @Date 2018/11/29 15:04
 */
public class Consumer {

    private final static String TOPIC = "jsk-test-rocketmq";

    public static void main(String[] args) throws InterruptedException, MQClientException {


        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("jsk_group");

        // Specify name server addresses.
//        consumer.setNamesrvAddr("test01.cdh.ecarx.local:9876;test02.cdh.ecarx.local:9876");
        consumer.setNamesrvAddr("dev.cdh.ecarx.local:9876");

//         Subscribe one more more topics to consume.
        consumer.subscribe(TOPIC, "OWNERDRIVER");
        // 订阅多个主题
//        consumer.setSubscription(new HashMap<String, String>(8){{
//            put("test-jsk", "");
//            put("tsp-txl-test", "");
//        }});

        // 设置每次拉取最大条数(32最好)
        consumer.setConsumeMessageBatchMaxSize(1);

        // 拉取消息最大线程数
        consumer.setConsumeThreadMax(10);
        // 拉取消息最小线程数(默认为20)
        consumer.setConsumeThreadMin(10);

        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf(TOPIC + "：%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                System.out.println("\n" + msgs.size());

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //Launch the consumer instance.
        consumer.start();
        System.out.printf("Consumer Started.%n");

    }
}
