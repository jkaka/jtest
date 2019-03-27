package com.kaka.jtest.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.Properties;

/**
 * @author: jsk
 * @date: 2019/3/26 15:08
 */
public class ProducerTest {

    @Test
    public void send(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "test.cdh.ecarx.local:9092,test01.cdh.ecarx.local:9092,test02.cdh.ecarx.local:9092");
        props.put("acks", "all");
//        props.put("delivery.timeout.ms", 30000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("jsk-topic", Integer.toString(i), Integer.toString(i)));

        producer.close();
    }
}
