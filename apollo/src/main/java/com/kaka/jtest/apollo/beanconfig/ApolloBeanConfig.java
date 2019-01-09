package com.kaka.jtest.apollo.beanconfig;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author jsk
 * @Date 2019/1/7 14:10
 */
@Component
public class ApolloBeanConfig {
    private final Logger logger = LoggerFactory.getLogger("");
    @Autowired
    private RefreshScope refreshScope;

    @ApolloConfigChangeListener({"application", "java.rocketmq"})
    private void someOnChange(ConfigChangeEvent changeEvent) {
        //update injected value of batch if it is changed in Apollo
        Set<String> changes = changeEvent.changedKeys();
        for(String key : changes) {
            logger.info("配置[" + key+"]发生变化：" + changeEvent.getChange(key));
            refreshScope.refresh("otaSyncConfig");
            refreshScope.refresh("devicePlatformConfig");
            refreshScope.refresh("otaSystemConfig");
            refreshScope.refresh("heReleaseConfig");
            refreshScope.refresh("rocketMqConfig");
        }

    }
}
