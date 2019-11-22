package com.kaka.jtest.springboot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-21 21:22
 */
@ConfigurationProperties(prefix = "my-properties")
@Component
@Data
public class MyProperties {
    private String key;
}
