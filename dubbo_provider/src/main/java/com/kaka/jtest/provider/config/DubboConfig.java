package com.kaka.jtest.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author shuangkaijia
 */
@Component
public class DubboConfig {
    // 应用名称
    @Value("${spring.dubbo.application1.name}")
    private String applicationName;

    // 协议名称
    @Value("${spring.dubbo.protocol.name}")
    private String protocolName;

    // 提供服务的服务端口号
    @Value("${spring.dubbo.protocol.port}")
    private Integer protocolPort;

    // 注册协议名称
    @Value("${spring.dubbo.registry.protocol}")
    private String registryProtocol;

    // 注册协议地址
    @Value("${spring.dubbo.registry.address}")
    private String registryAddress;

    // 监听协议名称
    @Value("${spring.dubbo.monitor.protocol}")
    private String monitorProtocol;

    // 监听协议地址
    @Value("${spring.dubbo.monitor.address}")
    private String monitorAddress;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public Integer getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(Integer protocolPort) {
        this.protocolPort = protocolPort;
    }

    public String getRegistryProtocol() {
        return registryProtocol;
    }

    public void setRegistryProtocol(String registryProtocol) {
        this.registryProtocol = registryProtocol;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public String getMonitorProtocol() {
        return monitorProtocol;
    }

    public void setMonitorProtocol(String monitorProtocol) {
        this.monitorProtocol = monitorProtocol;
    }

    public String getMonitorAddress() {
        return monitorAddress;
    }

    public void setMonitorAddress(String monitorAddress) {
        this.monitorAddress = monitorAddress;
    }
}
