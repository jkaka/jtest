package com.kaka.common.base;

import com.kaka.common.enums.ResultCode;
import lombok.Data;

/**
 * @author jsk
 * @Date 2018/10/15 9:06
 */
@Data
public class BaseResult<T> {
    private Boolean success = Boolean.FALSE;
    private String code = ResultCode.FAILURE.getCode();
    private String message;

    private T data;
    private String sessionId;

    private String businessMessage;
}
