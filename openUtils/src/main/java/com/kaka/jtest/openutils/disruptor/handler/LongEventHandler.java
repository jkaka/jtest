package com.kaka.jtest.openutils.disruptor.handler;

import com.kaka.jtest.openutils.disruptor.event.LongEvent;
import com.lmax.disruptor.EventHandler;

/**
 * 定义disruptor的【消费者】:实现disruptor的EventHandler，也就是一个事件处理器。
 * 这个事件处理器简单地把事件中存储的数据打印到终端
 * @author: jsk
 * @date: 2019/4/30 16:19
 */
public class LongEventHandler implements EventHandler<LongEvent>
{
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event);
    }
}