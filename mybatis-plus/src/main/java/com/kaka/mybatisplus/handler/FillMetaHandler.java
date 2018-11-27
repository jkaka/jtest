package com.kaka.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author jsk
 * @Date 2018/11/27 16:06
 */
@Component
public class FillMetaHandler implements MetaObjectHandler {
    /**
     * 插入操作 自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("email", metaObject);
        if(fieldValue == null) {
            System.out.println("*******插入操作 满足填充条件*********");
            setFieldValByName("email1", "12345666@163.com", metaObject);
        }
    }

    /**
     * 修改操作 自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName("email", metaObject);
        if(fieldValue == null) {
            System.out.println("*******修改操作 满足填充条件*********");
            setFieldValByName("email", "12345666@163.com", metaObject);
        }
    }
}
