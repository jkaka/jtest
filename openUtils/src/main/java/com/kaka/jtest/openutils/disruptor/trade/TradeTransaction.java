package com.kaka.jtest.openutils.disruptor.trade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jsk
 * @date: 2019/4/30 17:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeTransaction {
    private String id;//交易ID
    private double price;//交易金额
}