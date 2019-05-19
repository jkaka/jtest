package com.kaka.scheduler.beanconfig;

import org.apache.dubbo.config.*;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jsk
 * @Date 2018/12/20 16:09
 */
@Configuration
@DubboComponentScan("com.kaka.scheduler.task")
public class DubboBeanConfig {
    /**
     * 1.通信规则配置(有 dubbo、rest、http、hessian、webservice)
     * 在20880端口上使用dubbo协议来export服务
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);
        return protocolConfig;
    }

    /**
     * 1.当前应用配置，主要用来给注册中心计算应用间依赖关系。
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("scheduler");
        return applicationConfig;
    }

    /**
     * 2.注册中心配置(服务注册中心和发现中心)
     * 常见的协议有：zookeeper、multicast
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        // zookeeper协议
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("10.43.100.169:2181");
        return registryConfig;
    }

    /**
     * 4.监听地址、协议名
     * 统计服务和调用次数，调用时间监控中心。
     *
     * @return
     */
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("zookeeper");
        monitorConfig.setAddress("10.43.100.169:2181");
//        monitorConfig.setGroup("monitor-ota");
        return monitorConfig;
    }

    /**
     * 6.提供方配置(默认使用springboot的applicationConfig，现在指定自己设定的applicationConfig)
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
     * 7.消费配置(默认使用springboot的applicationConfig，现在指定自己设定的applicationConfig)
     *
     * @param applicationConfig
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig) {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setApplication(applicationConfig);
        return consumerConfig;
    }
}
