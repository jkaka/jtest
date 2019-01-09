package com.kaka.jtest.openutils.gson;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * @author jsk
 * @Date 2018/12/24 20:18
 */
public class GsonTest {

    @Test
    public void test(){
        Gson gson = new Gson();
        String json = gson.toJson("{\"bizCode\":\"00012\",\"bizId\":\"\",\"triggerType\":\"\",\"triggerCron\":\"\",\"triggerTime\":\"\",\"startTime\":\"\",\"endTime\":\"\",\"responseBody\":\"\",\"executeTopic\":\"\",\"executeTag\":\"\",\"microServiceCode\":\"\"}");

        System.out.println(json);
    }
}
