package com.kaka.jtest.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author shuangkaijia
 */
@Component
public class DubboConfig {
    @Value("${spring.dubbo.application.name}")
    private String applicationName;

    @Value("${spring.dubbo.protocol.name}")
    private String protocolName;

    @Value("${spring.dubbo.protocol.port}")
    private Integer protocolPort;

    @Value("${spring.dubbo.registry.protocol}")
    private String registryProtocol;

    @Value("${spring.dubbo.registry.address}")
    private String registryAddress;

    @Value("${spring.dubbo.monitor.protocol}")
    private String monitorProtocol;

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
