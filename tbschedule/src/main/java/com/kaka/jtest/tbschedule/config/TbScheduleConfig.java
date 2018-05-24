package com.kaka.jtest.tbschedule.config;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class TbScheduleConfig {
    @Bean
    public TBScheduleManagerFactory tbScheduleManagerFactory(@Value("${job.zkConfig.zkConnectString}") String zkConnectString,
                                                             @Value("${job.zkConfig.rootPath}") String rootPath,
                                                             @Value("${job.zkConfig.zkSessionTimeout}") String zkSessionTimeout,
                                                             @Value("${job.zkConfig.userName}") String userName,
                                                             @Value("${job.zkConfig.password}") String password,
                                                             @Value("${job.zkConfig.isCheckParentPath}") String isCheckParentPath) {
        TBScheduleManagerFactory tbScheduleManagerFactory = new TBScheduleManagerFactory();
        Properties properties = new Properties();
        properties.put("zkConnectString", zkConnectString);
        properties.put("rootPath", rootPath);
        properties.put("zkSessionTimeout", zkSessionTimeout);
        properties.put("userName", userName);
        properties.put("password", password);
        properties.put("isCheckParentPath", isCheckParentPath);
        try {
            System.out.println("zk信息：" + properties);
            tbScheduleManagerFactory.init(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("tbSchedule初始化完成...");
        return tbScheduleManagerFactory;
    }
}
