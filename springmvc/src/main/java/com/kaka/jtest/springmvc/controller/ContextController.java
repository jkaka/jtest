package com.kaka.jtest.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.util.Set;

/**
 * @author: jsk
 * @date: 2019/8/22 11:06
 */
@RestController
@RequestMapping("/contextController")
public class ContextController {

    /**
     * 获取服务端口号
     * -Dserver.port=8001
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getServerPort")
    public String throwJsonMappingException() throws Exception {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        return objectNames.iterator().next().getKeyProperty("port");
    }
}