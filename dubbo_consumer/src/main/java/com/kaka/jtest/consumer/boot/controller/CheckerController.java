package com.kaka.jtest.consumer.boot.controller;

import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.status.Status;
import org.apache.dubbo.common.status.StatusChecker;
import org.apache.dubbo.config.*;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.protocol.AbstractProtocol;
import org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol.getDubboProtocol;

/**
 * @author: jsk
 * @date: 2019/8/23 14:55
 */
@RestController
@RequestMapping("/checkerController")
public class CheckerController {
    @Autowired
    private ApplicationConfig application;
    @Autowired
    private RegistryConfig registry;

    @RequestMapping("/checker")
    public String checker() {
        StatusChecker checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("memory");
        Status status = checker.check();

        checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("load");
        status = checker.check();

        checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("spring");
        status = checker.check();

        checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("datasource");
        status = checker.check();

        checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("server");
        status = checker.check();

        checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("threadpool");
        status = checker.check();

        checker = ExtensionLoader.getExtensionLoader(StatusChecker.class).getExtension("registry");
        status = checker.check();
        return status.toString();
    }

    @RequestMapping("/referenceInfo")
    public String referenceInfo() {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface("com.kaka.jtest.provider.client.service.UserService");
        reference.setGeneric(true);
        reference.setVersion("1.0.0");
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        ExtensionFactory adaptiveExtension = ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension();
        adaptiveExtension.getExtension(ReferenceConfig.class, "");
        String Bean = "&@Reference(version=1.0.0) com.kaka.jtest.provider.client.service.TimeOutService";
        return "sleepFour";
    }

}
