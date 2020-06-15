package com.kaka.flink.udf;

import org.apache.flink.table.functions.FunctionContext;
import org.apache.flink.table.functions.ScalarFunction;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/09 17:43:22
 */
public class StringLengthUdf extends ScalarFunction {
    // 可选， open方法可以不写
    // 需要import org.apache.flink.table.functions.FunctionContext;
    @Override
    public void open(FunctionContext context) {
    }
    public long eval(String a) {
        return a == null ? 0 : a.length();
    }
    public long eval(String b, String c) {
        return eval(b) + eval(c);
    }
    //可选，close方法可以不写
    @Override
    public void close() {
    }
}