package com.kaka.jtest.binlog.api;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.QueryEventData;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;

import java.io.IOException;

/**
 * @author jsk
 * @Date 2018/12/14 19:16
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BinaryLogClient client = new BinaryLogClient(
                "127.0.0.1",
                3306,
                "root", "root");
        client.registerEventListener(event -> {
            EventData eventData = event.getData();
            System.out.println("事件类型:" + eventData);
            if(eventData instanceof QueryEventData){
                System.out.println(((QueryEventData) eventData).getSql());
            }else if(eventData instanceof TableMapEventData){
                System.out.println(((TableMapEventData) eventData).getTable());
            }
        });
        client.connect();
    }
}
