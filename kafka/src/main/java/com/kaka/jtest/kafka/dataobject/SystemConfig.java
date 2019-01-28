package com.kaka.jtest.kafka.dataobject;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author jsk
 * @Date 2018/12/10 16:27
 */
public class SystemConfig {
    private final Logger logger = LoggerFactory.getLogger("kafka");
    public static String AUTO_OFFSET_RESET_CONFIG = "auto.offset.reset";
    public static String KAFKA_BOOTSTRAP_SERVERS = "kafka." + ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
    public static String KAFKA_ACKS = "kafka." + ProducerConfig.ACKS_CONFIG;
    public static String KAFKA_LINGER_MS = "kafka." + ProducerConfig.LINGER_MS_CONFIG;
    public static String KAFKA_RETRIES = "kafka." + ProducerConfig.RETRIES_CONFIG;
    public static String KAFKA_KEY_SERIALIZER = "kafka." + ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
    public static String KAFKA_VALUE_SERIALIZER = "kafka." + ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;
    public static String KAFKA_PARTITIONER_CLASS = "kafka." + ProducerConfig.PARTITIONER_CLASS_CONFIG;
    public static String KAFKA_DEFAULT_PARTITIONER_CLASS = "com.ecarx.kafka.client.PartitionRuler";
    private Properties pro = null;

    private SystemConfig() {

    }

    public SystemConfig(Properties pro) {
        if (logger.isInfoEnabled()) {
            logger.info("kafka初始化参数如下：" + pro);
        }
        this.pro = pro;
    }

    public String get(String key) {
        if (pro != null && pro.containsKey(key)) {
            return pro.getProperty(key);
        } else {
            return null;
        }
    }

    public String get(String key, String defaultValue) {
        if (pro != null && pro.containsKey(key)) {
            String value = pro.getProperty(key);
            return value;
        } else {
            return defaultValue;
        }
    }
}
