package com.kaka.jtest.provider.boot.beanconfig;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.kaka.jtest.provider.config.DubboConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuangkaijia
 */
@Configuration
@DubboComponentScan(basePackages = "com.kaka.jtest.provider.biz.service")
public class DubboBeanConfig {
    @Autowired
    private DubboConfig dubboConfig;

    /**
     * 1.协议配置(有 dubbo、rest、http、hessian、webservice)
     * 在20880端口上使用dubbo协议来export服务
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
     * 1.当前应用配置，主要用来给注册中心计算应用间依赖关系。
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboConfig.getApplicationName());
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
        registryConfig.setProtocol(dubboConfig.getRegistryProtocol());
        registryConfig.setAddress(dubboConfig.getRegistryAddress());
        // zk的维度分组：分组后，监听的服务和注册的服务都会在这个分组中；默认值为dubbo
        registryConfig.setGroup("registry-ota");
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
        monitorConfig.setProtocol(dubboConfig.getMonitorProtocol());
        monitorConfig.setAddress(dubboConfig.getMonitorAddress());
//        monitorConfig.setGroup("monitor-ota");
        return monitorConfig;
    }

    /**
     * 5.设置dubbo扫描的包
     * 可以扫描到dubbo的注解，如：@Service、@Reference
     * 第一种：annotationBean
     * 第二种：在yml中配置spring.dubbo.scan的值
     * 第三种：使用@DubboComponentScan注解
     *
     * @param
     * @return
     */
    //@Bean
    public static AnnotationBean annotationBean(@Value("${spring.dubbo.scan}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
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
        // 提供者的维度分组：分组后所有提供的服务都会在这个组中。
//        providerConfig.setGroup("a-provider");
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
//        consumerConfig.setGroup("a-consumer");
        return consumerConfig;
    }
}
