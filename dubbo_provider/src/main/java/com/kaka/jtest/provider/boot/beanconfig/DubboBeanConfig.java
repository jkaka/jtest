package com.kaka.jtest.provider.boot.beanconfig;

import com.kaka.jtest.provider.config.DubboConfig;
import org.apache.dubbo.config.*;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuangkaijia
 */
@Configuration
@DubboComponentScan(basePackages = "com.kaka.jtest.provider.client.service")
public class DubboBeanConfig {
    @Autowired
    private DubboConfig dubboConfig;

    /**
     * 基础一、当前应用信息配置，主要用来给注册中心计算应用间依赖关系。
     * 项目中有相同的应用信息,会报错   但不影响服务正常使用
     * 解决：不配置这个就行了  因为1.0的starter会不管容器中是否存在,强制创建这个Bean
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboConfig.getApplicationName());
        Map<String,String> parameters = new HashMap<>();
//        parameters.put(Constants.ROUTER_KEY, "tag");
        applicationConfig.setParameters(parameters);
        return applicationConfig;
    }

    /**
     * 基础二、注册中心配置(服务注册中心和发现中心)
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
//        registryConfig.setGroup("registry-ota");
        registryConfig.setSimplified(true);
        return registryConfig;
    }

    @Bean
    public MetadataReportConfig metadataReportConfig(){
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://" + dubboConfig.getRegistryAddress());
        return metadataReportConfig;
    }
    /**
     * 基础三、通信规则配置(有 dubbo、rest、http、hessian、webservice)
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
     * 基础四(可选)、监听地址、协议名
     * 统计服务和调用次数，调用时间监控中心。
     *
     * @return
     */
//    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
//        monitorConfig.setAddress(dubboConfig.getMonitorAddress());
        return monitorConfig;
    }

    /**
     * 1.设置dubbo扫描的包
     * 可以扫描到dubbo的注解，如：@Service、@Reference
     * 第一种：使用下面AnnotationBean(不推荐)
     * 第二种：在yml中配置spring.dubbo.scan的值(不推荐)
     * 第三种：使用@DubboComponentScan注解
     * <p>
     * 同时使用以上方法，会扫描多次,进而产生多个提供者
     *
     * @param
     * @return
     */
    //@Bean
    /*public static AnnotationBean annotationBean(@Value("${spring.dubbo.scan}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }*/

    /**
     * 2.提供方配置(默认使用springboot的applicationConfig，现在指定自己设定的applicationConfig)
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

        // 这个名称在com.alibaba.dubbo.rpc.Filter文件中配置
//        providerConfig.setFilter("dubboTraceIdFilter");
//        providerConfig.setTag("tag001");
        return providerConfig;
    }

    /**
     * 3.消费配置(默认使用springboot的applicationConfig，现在指定自己设定的applicationConfig)
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


    /*@Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        //将method的设置关联到service配置中
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);

        //ProviderConfig
        //MonitorConfig

        return serviceConfig;
    }*/

}
