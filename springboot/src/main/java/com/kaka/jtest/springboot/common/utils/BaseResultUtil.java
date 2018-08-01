package com.kaka.jtest.springboot.common.utils;

import com.kaka.jtest.springboot.common.model.BaseResult;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BaseResultUtil {

    public static <T> BaseResult<T> handlerSuccess(T t, String message) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        if (StringUtils.isEmpty(message)) {
            message = "数据处理成功！";
        }
        baseResult.setMessage(message);
        baseResult.setCode("success");
        baseResult.setSuccess(true);
        return baseResult;
    }


    public static <T> BaseResult<T> handlerFailure(T t, String message) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        if (StringUtils.isEmpty(message)) {
            message = "数据处理失败！";
        }
        baseResult.setMessage(message);
        baseResult.setCode("success");
        baseResult.setSuccess(false);
        return baseResult;
    }
}