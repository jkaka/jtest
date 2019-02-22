package com.kaka.jtest.apollo.properties;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * EnableApolloConfig注解的作用: 把value对应namespace的配置注入到spring环境中
 * RefreshScope注解的作用: 动态刷新该配置类的属性值
 */
@EnableApolloConfig(value = "application", order = 1)
@RefreshScope
@Component
public class ApplicationProperties {
    @Value("{timeout}")
    private String timeout;

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "timeout='" + timeout + '\'' +
                '}';
    }
}
