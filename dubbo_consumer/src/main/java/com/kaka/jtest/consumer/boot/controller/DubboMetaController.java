package com.kaka.jtest.consumer.boot.controller;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol.getDubboProtocol;

/**
 * @author: jsk
 * @date: 2019/8/28 10:55
 */
@RestController
@RequestMapping("/dubboMetaController")
public class DubboMetaController {

    @RequestMapping("/dubboProtocol")
    public String dubboProtocol() {
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("dubbo");
        DubboProtocol dubboProtocol = getDubboProtocol();
        System.out.println(protocol == dubboProtocol);
        return "dubboProtocol";
    }
}
