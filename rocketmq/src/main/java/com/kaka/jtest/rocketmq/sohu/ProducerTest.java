package com.kaka.jtest.rocketmq.sohu;

import com.sohu.index.tv.mq.common.Result;
import com.sohu.tv.mq.rocketmq.RocketMQProducer;
import org.apache.rocketmq.client.producer.SendResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jsk
 * @date: 2019/5/6 16:55
 */
public class ProducerTest {
    public static void main(String[] args) {
        // 生产者初始化 注意：只用初始化一次
        RocketMQProducer producer = new RocketMQProducer("test01_group_name", "TopicTest");
// 注意，只用启动一次
        producer.start();

        Map<String, Object> message = new HashMap<String, Object>();
        message.put("vid", "123456");
        message.put("aid", "789172");
//这里message推荐使用map，当然也可以使用json
//建议设置keys(多个key用空格分隔)参数(也可以忽略该参数)，比如keys指定为vid，那么就可以根据vid查询消息
        Result<SendResult> sendResult = producer.publish(message, "keys：业务id，比如vid");
        if (!sendResult.isSuccess) {
            //失败消息处理
        }

// 应用退出时
        producer.shutdown();
    }
}
