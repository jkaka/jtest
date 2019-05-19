package com.kaka.jtest.openutils.disruptor.event;

/**
 * 生产者要生产的【event对象】，主动传递给disruptor中的RingBuffer
 *
 * @author: jsk
 * @date: 2019/4/30 16:14
 */
public class LongEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }
}
