package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.ApplicationTest;
import com.kaka.jtest.springboot.biz.service.MockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author jsk
 * @Date 2019/2/19 16:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockControllerTest extends ApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    /**
     * SpyBean注解标注的bean,原来bean方法体的内容;如果不使用Mockito自定义方法的返回值,则按照bean原来的方法体执行
     * MockBean注解标注的bean,不会保留原来bean方法体的内容;每个方法都需要使用Mockito自定义返回值,否则返回mock中对应类型定义的默认值
     */
    @MockBean
    private MockService mockService;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //初始化MockMvc对象
    }

    @Test
    public void one() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/mockController/one/111")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("响应结果：" + contentAsString);
    }

    /**
     * thenReturn先执行SpyBean中的对应方法体,再返回值
     * 如果方法体中有异常,则程序会中断
     *
     * @throws Exception
     */
    @Test
    public void twoThenReturn() throws Exception {
        Mockito.when(mockService.two(222))
                .thenReturn(55);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/mockController/two/222")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("响应结果：" + contentAsString);
    }

    /**
     * doReturn  不会执行spyBean中的方法,符合后面的参数直接就会返回
     *
     * @throws Exception
     */
    @Test
    public void twoDoReturn() throws Exception {
        Mockito.doReturn(66)
                .when(mockService).two(222);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/mockController/two/222")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("响应结果：" + contentAsString);
    }

    @Test
    public void three() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/mockController/three/333")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("响应结果：" + contentAsString);
    }
}