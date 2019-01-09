package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.biz.dataobject.User;
import com.kaka.jtest.springboot.biz.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author jsk
 * @Date 2018/11/5 13:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private MockHttpSession session;

    @MockBean
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        Mockito.when(userService.selectOne(8L))
                .thenReturn(new User(8,"mock的名称"));
//        User user =new User("root","root");
//        session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }


    /**
     * 查询
     * @throws Exception
     */
    @Test
    public void selectUser() throws Exception {
        // mockMvc.perform执行一个请求
        mockMvc.perform(MockMvcRequestBuilders.get("/testController/user/8")// MockMvcRequestBuilders构造一个请求，Post请求就用.post方法
                .contentType(MediaType.APPLICATION_JSON_UTF8)// contentType(MediaType.APPLICATION_JSON_UTF8)代表发送端发送的数据格式是application/json;charset=UTF-8
                .accept(MediaType.APPLICATION_JSON_UTF8)// accept(MediaType.APPLICATION_JSON_UTF8)代表客户端希望接受的数据类型为application/json;charset=UTF-8
                .session(session)// session(session)注入一个session，这样拦截器才可以通过
        )// ResultActions.andExpect添加执行完成后的断言
                .andExpect(MockMvcResultMatchers.status().isOk())// 方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("8"))// 这里jsonPath用来获取id字段的值,比对是否为预期值,不是就测试不通过
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("jsk"))
                .andDo(MockMvcResultHandlers.print());// 添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
    }

    /**
     * 新增User
     * 415:服务器无法处理请求附带的媒体格式
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void addUser() throws Exception {
        String json = "{\"name\":\"test\",\"age\": 23}";
        mockMvc.perform(MockMvcRequestBuilders.post("/testController/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes()) //传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        System.out.println("新增User测试完毕！");
    }

    /**
     * 修改教程测试用例
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void updateLearn() throws Exception {
        String json = "{\"id\":5,\"name\":\"test\",\"age\":23}";
        mockMvc.perform(MockMvcRequestBuilders.put("/testController/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes())//传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除教程测试用例
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Ignore("这个不需要test")
    public void deleteLearn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/testController/user/4")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}