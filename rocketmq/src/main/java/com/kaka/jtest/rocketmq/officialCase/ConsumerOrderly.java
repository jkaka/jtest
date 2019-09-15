package com.kaka.jtest.rocketmq.officialCase;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

        // 有序消息   一个线程对应一个队列
        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs,
                                                       ConsumeOrderlyContext context) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf(TOPIC + "：%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                System.out.println("\n" + msgs.size());

                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        //Launch the consumer instance.
        consumer.start();
        System.out.printf("Consumer Started.%n");

    }
}
