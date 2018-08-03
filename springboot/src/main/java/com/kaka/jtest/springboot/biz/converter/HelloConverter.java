package com.kaka.jtest.springboot.biz.converter;

import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.springboot.biz.dataobject.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * user消息转换器
 *
 * @author shuangkaijia
 */
@Component
public class HelloConverter extends AbstractHttpMessageConverter<User> {
    @Override
    protected boolean supports(Class<?> aClass) {
        System.out.println("3.converter:" + aClass);
        return User.class.isAssignableFrom(aClass);
    }

    /**
     * 自定义@RequestBody User
     *
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("3.1 converter.readInternal();");
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(),
                Charset.forName("UTF-8"));
        System.out.println(temp);
        return JSONObject.parseObject(temp, User.class);
    }

    /**
     * 自定义@ResponseBody User
     *
     * @param o
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(User o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("3.2 converter.writeInternal();响应结果：" + o.toString() + "(原样输出)");
        httpOutputMessage.getBody().write(o.toString().getBytes());
    }
}
