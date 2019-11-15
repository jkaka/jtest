package com.kaka.jtest.aliyun.bss;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.bssopenapi.model.v20171214.QueryBillRequest;
import com.aliyuncs.bssopenapi.model.v20171214.QueryBillResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "LTAI4FqNv8qZRXmZGvWijf9z",
                "ToOaw7kAZlCElvfBJdohi3pYqIZuR6");
        IAcsClient client = new DefaultAcsClient(profile);
        // 创建API请求并设置参数
        QueryBillRequest request = new QueryBillRequest();
        request.setPageNum(1);
        request.setPageSize(300);
        request.setBillingCycle("2019-11");
        // 发起请求并处理应答或异常
        try {
            QueryBillResponse queryBillResponse = client.getAcsResponse(request);
            List<QueryBillResponse.Data.Item> items = queryBillResponse.getData().getItems();
            for (QueryBillResponse.Data.Item item : items) {
                System.out.println(item.getRecordID() + ";" + item.getPretaxGrossAmount() + "；" + item.getUsageStartTime());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}