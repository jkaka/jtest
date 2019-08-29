package com.kaka.jtest.springboot.biz.indicator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 方式二
 * AbstractHealthIndicator 实现 HealthIndicator 接口，并重写了 health() 方法来实现健康检查。
 * 因此，我们只需要重写 doHealthCheck 方法即可。
 *
 * @author: jsk
 * @date: 2019/8/22 16:58
 */
@Component
public class CustomAbstractHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("abstract", "test")
                .withDetail("key002", 999)
                .up();
    }
}
