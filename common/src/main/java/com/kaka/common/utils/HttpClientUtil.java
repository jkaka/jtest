package com.kaka.common.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/10/13 17:36
 */
public class HttpClientUtil {
    static final String CHARSET = "UTF-8";
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String getHttpsGet(String url, Map<String, String> headParams) {
        HttpGet httpGet;
        String result = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            for (Map.Entry<String, String> entry : headParams.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, CHARSET);
                }
            }
        } catch (Exception ex) {
            logger.error("request error, e:", ex);
        }
        logger.info(" request uri :" + url);
        logger.info(" response json :" + result);
        return result;
    }

    public static String getHttpsPost(String url, Map<String, String> headParams, String bodyParams) {
        HttpPost httpPost;
        String result = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            if (headParams != null && !headParams.isEmpty()) {
                for (Map.Entry<String, String> entry : headParams.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            ByteArrayEntity entity = new ByteArrayEntity(bodyParams.getBytes());
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, CHARSET);
                }
            }
        } catch (Exception ex) {
            logger.error("request error, e:", ex);
        }
        logger.info(" request uri :" + url);
        logger.info(" request json :" + bodyParams);
        logger.info(" response json :" + result);
        return result;
    }

    public static String getHttpsPut(String url, Map<String, String> headParams, String bodyParams) {
        HttpPut httpPut;
        String result = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            httpPut = new HttpPut(url);
            //设置参数
            if (!headParams.isEmpty()) {
                for (Map.Entry<String, String> entry : headParams.entrySet()) {
                    httpPut.setHeader(entry.getKey(), entry.getValue());
                }
            }
            ByteArrayEntity entity = new ByteArrayEntity(bodyParams.getBytes());
            httpPut.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPut);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, CHARSET);
                }
            }
        } catch (Exception ex) {
            logger.error("request error, e:", ex);
        }
        logger.info(" request uri :" + url);
        logger.info(" request json :" + bodyParams);
        logger.info(" response json :" + result);
        return result;
    }

    public static String getHttpsDelete(String url, Map<String, String> headParams) {
        HttpDelete httpDelete;
        String result = null;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            httpDelete = new HttpDelete(url);
            //设置参数
            if (!headParams.isEmpty()) {
                for (Map.Entry<String, String> entry : headParams.entrySet()) {
                    httpDelete.setHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpResponse response = httpClient.execute(httpDelete);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, CHARSET);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.info(" request uri :" + url);
        logger.info(" response json :" + result);
        return result;
    }

    public static String multipartPost(String url, Map<String, String> headParams, Map<String, Object> multipartBody) {
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //设置参数
        if (!headParams.isEmpty()) {
            for (Map.Entry<String, String> entry : headParams.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 设置其他参数
        for (Map.Entry<String, Object> entry : multipartBody.entrySet()) {
            // 上传的文件
            if (entry.getValue() instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) entry.getValue();
                try {
                    builder.addBinaryBody(entry.getKey(), file.getInputStream(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());
                } catch (IOException e) {
                    logger.error("change file to stream error, e:" + e);
                    return null;
                }
            } else {
                builder.addTextBody(entry.getKey(), entry.getValue().toString(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
            }
        }
        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            logger.error("execute mutipartFrom error, e:" + e);
            return null;
        }
        if (null == response || response.getStatusLine() == null) {
            logger.info("Post Request For Url[{}] is not ok. Response is null", url);
            return null;
        } else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            logger.info("Post Request For Url[{}] is not ok. Response Status Code is {}", url,
                    response.getStatusLine().getStatusCode());
            return null;
        }
        try {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            logger.error("change multipartFrom result to String error, e:" + e);
            return null;
        }
    }
}
