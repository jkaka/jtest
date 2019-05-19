package com.kaka.jtest.openutils.disruptor.factory;

import com.kaka.jtest.openutils.disruptor.event.LongEvent;
import com.lmax.disruptor.EventFactory;

/**
 * 实现disruptor的【事件工厂】EventFactory，让disruptor批量产生longEvent
 * Disruptor 通过 EventFactory 在 RingBuffer 中预创建 Event 的实例。
 * 一个 Event 实例实际上被用作一个“数据槽”，发布者发布前，先从 RingBuffer 获得一个 Event 的实例，然后往 Event 实例中填充数据，
 * 之后再发布到 RingBuffer 中，之后由 Consumer 获得该 Event 实例并从中读取数据。
 *
 * @author: jsk
 * @date: 2019/4/30 16:15
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}