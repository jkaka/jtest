package com.kaka.common.constants;

/**
 * @author jsk
 * @Date 2018/10/31 14:29
 */
public interface Constants {
    /**
     * 常用字符
     */
    String SEPARATOR_CHARS = "_";
    String SEMICOLON_CHARS = ";";
    String EQUALS_SIGN_CHARS = "=";
    String BACKSLASH_SIGN_CHARS = "/";

    /**
     * 分页
     */
    String OFFSET_KEY = "offset";
    String LIMIT_KEY = "limit";
    String PAGE_SIZE = "pageSize";
    String PAGE_INDEX = "pageIndex";
    Long OFFSET = 0L;
    Long LIMIT_1 = 1L;
    Long LIMIT_500 = 500L;
    Long LIMIT_1000 = 1000L;


    String ENCODING_UTF8 = "utf-8";
    /**
     * http协议
     */
    String PROTOCOL_HTTP = "http://";
    /**
     * header
     */
    String ACCEPT_LANGUAGE="Accept-Language";


    /**
     * 环境变更key
     */
    String X_ENV_TYPE = "X-ENV-TYPE";

    String STATUS = "status";
    String OPEN_SERVICE = "openservice";


}
