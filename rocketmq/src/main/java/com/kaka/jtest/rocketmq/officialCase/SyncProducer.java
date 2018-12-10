package com.kaka.jtest.rocketmq.officialCase;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author jsk
 * @Date 2018/11/27 22:07
 */
public class SyncProducer {

    /**
     * 可靠的同步传输广泛应用于重要的通知消息、短信通知、短信营销系统等场景。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("www");
        // Specify name server addresses.
        producer.setNamesrvAddr("10.43.100.169:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 2; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("topic_jsk001" /* Topic */,
                    "tag01" /* Tag */,
                    ("Hello RocketMQ 贾双凯" +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
