package com.kaka.jtest.springboot.biz.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 方式一
 * 自定义指示器,结果会显示在/actuator/health的details中
 * MyHealthIndicator首字母小写,剔除"HealthIndicator"就是details中的key;本类的key就是my
 *
 * @author: jsk
 * @date: 2019/8/22 16:09
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return new Health.Builder()
                .withDetail("key01", 99)
                .withDetail("key02", "hello")
                .up()
                .build();
    }
}
