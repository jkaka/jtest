package com.kaka.jtest.springboot.common.utils;

import com.kaka.jtest.springboot.common.model.BaseResult;

import java.util.List;

public class BaseResultUtil {

    public static <T> BaseResult<T> handlerSuccessOne(T t){
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setData(t);
        baseResult.setCode("success");
        baseResult.setMessage("调用方法成功");
        baseResult.setSuccess(true);
        return baseResult;
    }

    public static <T> BaseResult<T> handlerFailureOne(T t){
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.setCode("failure");
        baseResult.setMessage("调用方法失败");
        baseResult.setSuccess(false);
        return baseResult;
    }

    public static <T> BaseResult<List<T>> handlerSuccessList(List<T> t){
        BaseResult<List<T>> baseResult = new BaseResult<>();
        baseResult.setData(t);
        baseResult.setCode("success");
        baseResult.setSuccess(true);
        baseResult.setMessage("调用方法成功");
        return baseResult;
    }

    public static <T> BaseResult<List<T>> handlerFailureList(List<T> t){
        BaseResult<List<T>> baseResult = new BaseResult<>();
        baseResult.setCode("failure");
        baseResult.setSuccess(false);
        baseResult.setMessage("调用方法失败");
        return baseResult;
    }
}