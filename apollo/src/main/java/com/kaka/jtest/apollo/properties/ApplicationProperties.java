package com.kaka.jtest.apollo.properties;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableApolloConfig(value = "application", order = 1)
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
