package com.kaka.jtest.springboot.boot.beanconfig;

import com.kaka.jtest.springboot.biz.converter.HelloConverter;
import com.kaka.jtest.springboot.biz.interceptor.RequestInterceptor;
import com.kaka.jtest.springboot.biz.interceptor.UriInterceptor;
import com.kaka.jtest.springboot.biz.security.AuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuangkaijia
 */
@Configuration
public class WebBeanConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private HelloConverter helloConverter;
    @Autowired
    private RequestInterceptor requestInterceptor;
    @Autowired
    private UriInterceptor uriInterceptor;

    /**
     * 1.过滤器注册
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myOncePerRequestFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationTokenFilter());
        // 过滤路径
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("AuthenticationTokenFilter");
        // 过滤器顺序
        registration.setOrder(2);
        return registration;
    }

    /**
     * 2.拦截器注册
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor).addPathPatterns("/**");
        registry.addInterceptor(uriInterceptor).addPathPatterns("/**");
    }

    /**
     * 3.消息转换器注册
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //1.定义convert转换消息的对象;
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        //FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        helloConverter.setSupportedMediaTypes(fastMediaTypes);
        //fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        //5.将convert添加到converters当中.
        converters.add(helloConverter);
    }

    /**
     * 客户端上传文件的时候,会先把文件传到服务的这个临时文件夹中,然后进入controller方法。
     * 上传大文件时，推荐使用分片上传：客户端把文件分成小文件上传
     * 或者断点续传：
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("1024000KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("1024000KB");
        File file = new File("E:/springboot/upload12");
        if (!file.exists()) {
            file.mkdirs();
        }
        factory.setLocation(file.getAbsolutePath());
        return factory.createMultipartConfig();
    }
}
