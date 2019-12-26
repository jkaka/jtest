package com.kaka.jtest.openutils.logback.core.rolling;

import java.util.concurrent.TimeUnit;

import com.kaka.jtest.openutils.slf4j.LogUtil;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @date 2019/12/25 11:23:53
 */
public class SizeAndTimeBasedRollingPolicyTest {
    private LogUtil logger = new LogUtil("jsk");

    /**
     * 单个日志文件最大1M左右
     * <MaxFileSize>1MB</MaxFileSize>
     * 最多保留5天的日志
     * <MaxHistory>5</MaxHistory>
     * 最多保留3M的总日志文件
     * <TotalSizeCap>3MB</TotalSizeCap>
     */
    @Test
    public void rollingTest() throws InterruptedException {
        int i = 0;
        while(true){
            logger.info("第" + i + "条日志~");
            TimeUnit.MILLISECONDS.sleep(1);
            i ++;
        }
    }
}
