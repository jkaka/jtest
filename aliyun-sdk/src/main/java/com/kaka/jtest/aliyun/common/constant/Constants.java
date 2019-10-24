package com.kaka.jtest.aliyun.common.constant;

import com.kaka.common.utils.PropertiesUtil;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 11:00
 */
public interface Constants {
    String ACCESS_ID = PropertiesUtil.getLocalProperty("accessKeyId");
    String ACCESS_KEY = PropertiesUtil.getLocalProperty("accessKey");
    String OSS_ROLE_ARN = PropertiesUtil.getLocalProperty("oss.role.arn");
    String BSS_ROLE_ARN = PropertiesUtil.getLocalProperty("bss.role.arn");
}
