package com.kaka.jtest.rocketmq.controller;

import com.kaka.common.utils.LogUtil;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jsk
 * @Date 2018/11/29 16:13
 */
@RestController
@RequestMapping("/rocketController")
public class RocketController {
    private LogUtil logger = new LogUtil("jsk");

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @PostMapping("/send")
    public SendResult send() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String msg = "demo msg test";
        logger.info("开始发送消息："+msg);
        Message sendMsg = new Message("DemoTopic","DemoTag",msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        logger.info("消息发送响应信息："+sendResult.toString());
        return sendResult;
    }
}
