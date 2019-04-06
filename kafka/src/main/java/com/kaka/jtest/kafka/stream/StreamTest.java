package com.kaka.jtest.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.junit.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/3/26 15:26
 */
public class StreamTest {

    @Test
    public void start() throws Exception {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "group_1");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dev.cdh.ecarx.local:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
//        builder.<String, String>stream("my-input-topic").mapValues(String::length).to("my-output-topic");
        builder.<String, String>stream("devices-command-RVC").mapValues(str ->{
            System.out.println(str);
            return "AA";
        });

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
