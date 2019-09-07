package com.kaka.jtest.rocketmq.officialCase;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2018/11/29 15:03
 */
public class OnewayProducer {

    /**
     * 单向传输用于需要中等可靠性的情况，例如日志收集。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("test01_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("dev.cdh.ecarx.local:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 1000; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("jsk-test-rocketmq",
                    "OWNERDRIVER",
                    ("Hello linkedlistRocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            producer.sendOneway(msg);
            System.out.println("发送消息:" + msg);
            TimeUnit.SECONDS.sleep(1);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
