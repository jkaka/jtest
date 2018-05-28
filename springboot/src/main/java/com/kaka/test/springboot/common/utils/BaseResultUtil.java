package com.kaka.test.springboot.common.utils;

import com.kaka.test.springboot.common.model.BaseResult;

import java.util.List;

public class BaseResultUtil {

    public static <T> BaseResult<T> handlerOne(T t) {
        BaseResult<T> baseResult = new BaseResult<T>();
        baseResult.setData(t);
        baseResult.setCode("success");
        baseResult.setMessage("数据查询成功");
        baseResult.setSuccess(true);
        return baseResult;
    }

    public static <T> BaseResult<T> handlerOneFaile(T t) {
        BaseResult<T> baseResult = new BaseResult<T>();
        baseResult.setCode("failure");
        baseResult.setMessage("数据查询失败");
        baseResult.setSuccess(false);
        return baseResult;
    }

    public static <T> BaseResult<List<T>> handlerList(List<T> t) {
        BaseResult<List<T>> baseResult = new BaseResult<List<T>>();
        baseResult.setData(t);
        baseResult.setCode("success");
        baseResult.setSuccess(true);
        baseResult.setMessage("数据查询成功");
        return baseResult;
    }

    public static <T> BaseResult<List<T>> handlerListFaile(List<T> t) {
        BaseResult<List<T>> baseResult = new BaseResult<List<T>>();
        baseResult.setCode("failure");
        baseResult.setSuccess(false);
        baseResult.setMessage("数据查询失败");
        return baseResult;
    }
}
