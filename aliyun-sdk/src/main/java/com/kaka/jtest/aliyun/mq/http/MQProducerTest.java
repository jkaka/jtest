package com.kaka.jtest.aliyun.mq.http;

import com.aliyun.mq.http.MQProducer;
import com.aliyun.mq.http.model.TopicMessage;
import com.kaka.jtest.aliyun.mq.MqBaseTest;

import java.util.Date;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-25 15:58
 */
public class MQProducerTest extends MqBaseTest {
	public static void main(String[] args) {
		// 获取Topic的生产者
		MQProducer producer = mqClient.getProducer(topic);

		try {
			// 循环发送4条消息
			for (int i = 0; i < 4; i++) {
				TopicMessage pubMsg;
				if (i % 2 == 0) {
					// 普通消息
					pubMsg = new TopicMessage(
							// 消息内容
							"hello mq!".getBytes(),
							// 消息标签
							"A"
					);
					// 设置属性
					pubMsg.getProperties().put("a", String.valueOf(i));
					// 设置KEY
					pubMsg.setMessageKey("MessageKey");
				} else {
					pubMsg = new TopicMessage(
							// 消息内容
							"hello mq!".getBytes(),
							// 消息标签
							"A"
					);
					// 设置属性
					pubMsg.getProperties().put("a", String.valueOf(i));
					// 定时消息, 定时时间为10s后
					pubMsg.setStartDeliverTime(System.currentTimeMillis() + 10 * 1000);
				}
				// 同步发送消息，只要不抛异常就是成功
				TopicMessage pubResultMsg = producer.publishMessage(pubMsg);

				// 同步发送消息，只要不抛异常就是成功
				System.out.println(new Date() + " Send mq message success. Topic is:" + topic + ", msgId is: " + pubResultMsg.getMessageId()
						+ ", bodyMD5 is: " + pubResultMsg.getMessageBodyMD5());
			}
		} catch (Throwable e) {
			// 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理
			System.out.println(new Date() + " Send mq message failed. Topic is:" + topic);
			e.printStackTrace();
		}

		mqClient.close();
	}
}
