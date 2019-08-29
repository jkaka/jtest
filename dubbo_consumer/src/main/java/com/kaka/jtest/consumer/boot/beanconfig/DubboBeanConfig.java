package com.kaka.jtest.consumer.boot.beanconfig;

import org.apache.dubbo.config.*;
import com.kaka.jtest.consumer.config.DubboConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DubboBeanConfig {
    @Autowired
    private DubboConfig dubboConfig;

    /**
     * 1.通信规则配置(有 dubbo、rest、http、hessian、webservice)
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(dubboConfig.getProtocolName());
        protocolConfig.setPort(dubboConfig.getProtocolPort());
        return protocolConfig;
    }

    /**
     * 2.当前应用配置
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboConfig.getApplicationName());
        Map<String,String> parameters = new HashMap<>();
        parameters.put("", "tag");
        applicationConfig.setParameters(parameters);
        return applicationConfig;
    }

    /**
     * 3.注册中心配置
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        // zookeeper协议
        registryConfig.setProtocol(dubboConfig.getRegistryProtocol());
        registryConfig.setAddress(dubboConfig.getRegistryAddress());
        // zk的维度分组：分组后，监听的服务和注册的服务都会在这个分组中；默认值为dubbo
//        registryConfig.setGroup("registry-ota");
        return registryConfig;
    }

    /**
     * 4.监听地址、协议名
     *
     * @return
     */
//    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol(dubboConfig.getMonitorProtocol());
        monitorConfig.setAddress(dubboConfig.getMonitorAddress());
//        monitorConfig.setGroup("b-monitor");
        return monitorConfig;
    }

    /**
     * 5.设置dubbo扫描包
     *
     * @param
     * @return
     */
//    @Bean
    /*public static AnnotationBean annotationBean(@Value("${spring.dubbo.scan}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }*/

    /**
     * 6.提供方配置
     *
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
    @Bean
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
    }

    /**
     * 7.消费配置(所有reference的缺省配置)
     *
     * @param applicationConfig
     * @param registryConfig
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setApplication(applicationConfig);
        consumerConfig.setFilter("activelimit,consumer_filter,testFilter");
        consumerConfig.setTimeout(30000);
//        consumerConfig.setTag("tag1");
        // 默认是随机（random）
        consumerConfig.setLoadbalance("leastactive");
//        consumerConfig.setFilter("activelimit,consumer_filter");
        // 这个不能在application的配置文件中配置
        consumerConfig.setCheck(false);
        return consumerConfig;
    }
}
