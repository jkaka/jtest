package com.kaka.jtest.openutils.disruptor.main;

import com.kaka.jtest.openutils.disruptor.event.LongEvent;
import com.kaka.jtest.openutils.disruptor.factory.LongEventFactory;
import com.kaka.jtest.openutils.disruptor.handler.LongEventHandler;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/4/30 16:20
 */
public class LongMainTest {

    public static void main(String[] args) throws InterruptedException {
        //创建LongEvent事件工厂
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        //创建缓冲线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //创建bufferSize缓冲区 ,也就是RingBuffer大小，要求必须是2的N次方
        int ringBufferSize = 1024 * 1024;

        /**
         * 1.创建disruptor实例，并传入泛型LongEvent事件类型（数据类型）
         * 构造参数：
         * Disruptor(
         * factory,--事件工厂，用于创建LongEvent，也就是实际最终被消费的数据
         * ringBufferSize,--缓冲区大小
         * executor,--线程池，作用是使用线程池进行内部数据接收处理调度
         * producerType,--两种形式：SINGLE(生产者只有一个)和MULTI(生产者有多个)
         * waitStrategy--决定一个消费者将如何等待生产者将EVENT放入disruptor)
         */
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
                ringBufferSize, executor, ProducerType.SINGLE,
                new YieldingWaitStrategy());

        // 2.创建消费者处理器,并连接到disruptor实例
        EventHandler<LongEvent> eventHandler = new LongEventHandler();
        // 连接消费事件方法，监听ringbuffer环形队列容器中的事件，有则取出消费，无则阻塞，所以disruptor相当于一个特殊的有界阻塞队列
        // 这个方法可以使用职责链模式，例如handleEventsWith(A).then(B)。
        disruptor.handleEventsWith(eventHandler);

        // 启动disruptor
        disruptor.start();

        // 3.ringBuffer发布事件：Disruptor 的事件发布过程是一个两阶段提交的过程
        // 获得具体存放数据的容器ringBuffer(环形结构)
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        // 3.1 lambda方式发布事件：publishEvent()
        ringBuffer.publishEvent((event, sequeue, buffer) -> {
                    event.set(888L);
                }
        );
        // 3.2 原生api方式
        // 3.2.1 从 RingBuffer 获取下一个可以写入的事件的序号
        long sequence = ringBuffer.next();
        try {
            // 3.2.2 用上面的索引取出一个空的事件用于填充（获取该序号对应的事件对象）
            LongEvent event = ringBuffer.get(sequence);
            // 3.2.3 设置要通过事件传递的业务数据；
            long data = 888L;
            event.set(data);
        } finally {
            // 3.2.4 发布事件
            // 必须包含在 finally 中以确保必须得到调用；如果某个请求的 sequence 未被提交，将会堵塞后续的发布操作或者其它的 producer。
            // 只有发布后才能被监听的消费者消费掉
            ringBuffer.publish(sequence);
        }
        TimeUnit.MILLISECONDS.sleep(50);

        // 4.关闭 Disruptor
        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
        executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
    }
}
