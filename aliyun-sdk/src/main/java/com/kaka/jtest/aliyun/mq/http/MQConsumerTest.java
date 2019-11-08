package com.kaka.jtest.aliyun.mq.http;

import com.aliyun.mq.http.MQConsumer;
import com.aliyun.mq.http.common.AckMessageException;
import com.aliyun.mq.http.model.Message;
import com.kaka.jtest.aliyun.mq.MqBaseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-25 15:59
 */
public class MQConsumerTest extends MqBaseTest {
	public static void main(String[] args) {
		// 您在控制台创建的 Consumer ID(Group ID)
		final String groupId = "GID_jsk_test";

		final MQConsumer consumer;
		consumer = mqClient.getConsumer(topic, groupId);
		// 在当前线程循环消费消息，建议是多开个几个线程并发消费消息
		do {
			List<Message> messages = null;

			try {
				// 长轮询消费消息
				// 长轮询表示如果topic没有消息则请求会在服务端挂住3s，3s内如果有消息可以消费则立即返回
				messages = consumer.consumeMessage(
						3,// 一次最多消费3条(最多可设置为16条)
						3// 长轮询时间3秒（最多可设置为30秒）
				);
			} catch (Throwable e) {
				e.printStackTrace();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			// 没有消息
			if (messages == null || messages.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + ": no new message, continue!");
				break;
			}

			// 处理业务逻辑
			for (Message message : messages) {
				System.out.println("Receive message: " + message);
				System.out.println("Receive message: " + message.getMessageBodyString());
			}

			// Message.nextConsumeTime前若不确认消息消费成功，则消息会重复消费
			// 消息句柄有时间戳，同一条消息每次消费拿到的都不一样
			{
				List<String> handles = new ArrayList<String>();
				for (Message message : messages) {
					handles.add(message.getReceiptHandle());
				}

				try {
					consumer.ackMessage(handles);
				} catch (Throwable e) {
					// 某些消息的句柄可能超时了会导致确认不成功
					if (e instanceof AckMessageException) {
						AckMessageException errors = (AckMessageException) e;
						System.out.println("Ack message fail, requestId is:" + errors.getRequestId() + ", fail handles:");
						if (errors.getErrorMessages() != null) {
							for (String errorHandle : errors.getErrorMessages().keySet()) {
								System.out.println("Handle:" + errorHandle + ", ErrorCode:" + errors.getErrorMessages().get(errorHandle).getErrorCode()
										+ ", ErrorMsg:" + errors.getErrorMessages().get(errorHandle).getErrorMessage());
							}
						}
						continue;
					}
					e.printStackTrace();
				}
			}
		} while (true);
		mqClient.close();
	}
}
