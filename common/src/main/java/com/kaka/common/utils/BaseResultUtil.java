package com.kaka.common.utils;

import com.kaka.common.base.BaseResult;
import com.kaka.common.enums.ResultCode;
import org.springframework.util.StringUtils;

/**
 * 供call、client(openservice)层调用业务层时使用
 *
 * @author jsk
 * @Date 2018/10/24 11:20
 */
public class BaseResultUtil {
    public static <T> BaseResult<T> selectSuccess(T t) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        baseResult.setMessage("查询数据成功！");
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setSuccess(true);
        return baseResult;
    }

    public static <T> BaseResult<T> handlerSuccess(T t) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        baseResult.setMessage("数据处理成功！");
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setSuccess(true);
        return baseResult;
    }

    public static <T> BaseResult<T> handlerSuccess(T t, String message) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        if (StringUtils.isEmpty(message)) {
            message = "数据处理成功！";
        }
        baseResult.setMessage(message);
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setSuccess(true);
        return baseResult;
    }


    /**
     * call层使用：参数不合法时直接返回,不去调用call层
     *
     * @param t
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> handlerFailure(T t, String message) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        if (StringUtils.isEmpty(message)) {
            message = "数据处理失败！";
        }
        baseResult.setMessage(message);
        baseResult.setCode(ResultCode.FAILURE.getCode());
        baseResult.setSuccess(false);
        return baseResult;
    }

    /**
     * call层使用：参数不合法时直接返回,不去调用client层
     *
     * @param t
     * @param e
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> handlerFailure(T t, Exception e) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        baseResult.setMessage(e.getMessage());
        baseResult.setCode(ResultCode.FAILURE.getCode());
        baseResult.setSuccess(false);
        return baseResult;
    }

    /**
     * client层使用：包装数据,返回给调用方
     *
     * @param baseResult
     * @param message
     */
    public static void wrapFailure(BaseResult baseResult, String message) {
        if (StringUtils.isEmpty(message)) {
            message = "数据处理失败！";
        }
        baseResult.setMessage(message);
        baseResult.setCode(ResultCode.FAILURE.getCode());
        baseResult.setSuccess(false);
    }

    /**
     * client层使用：包装数据,返回给调用方
     *
     * @param baseResult
     */
    public static void wrapSuccess(BaseResult baseResult) {
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setSuccess(true);
    }

    /**
     * client层使用：包装数据,返回给调用方
     *
     * @param baseResult
     * @param data
     * @param <T>
     */
    public static <T> void wrapSuccess(BaseResult<T> baseResult, T data) {
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setSuccess(true);
        baseResult.setData(data);
    }

    /**
     * client层使用：包装数据,返回给调用方
     *
     * @param baseResult
     * @param data
     * @param <T>
     */
    public static <T> void wrapSuccess(BaseResult<T> baseResult, T data, String message) {
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setSuccess(true);
        baseResult.setData(data);
        baseResult.setMessage(message);
    }
}
