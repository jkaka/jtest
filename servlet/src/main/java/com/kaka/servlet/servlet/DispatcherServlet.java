package com.kaka.servlet.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: jsk
 * @date: 2019/5/10 10:04
 */
public class DispatcherServlet extends HttpServlet {
    private String preActionName;
    /**
     * 加载配置文件(得到action的包名)
     */ {
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(is);
            preActionName = properties.getProperty("ActionPackage");
        } catch (Exception e) {
            System.out.println("加载config.properties出错：");
            e.printStackTrace();
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("servlet初始化方法");
    }

    /**
     * 请求处理方法
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            dispatcherToAction(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 分发给各个Action
     *
     * @throws IOException
     * @throws ServletException
     */
    private void dispatcherToAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] arr = getActionAndMethodName(request);
        String actionName = preActionName + "." + arr[0];
        String methodName = arr[1].replace(".action", "");
        //1.得到对应Action对象
        Class<?> clzAction = Class.forName(actionName);
        System.out.println("初始化action");
        Object actionInstance = clzAction.newInstance();
        System.out.println("初始化action结束");
        //2.给action对象的各个属性赋值
        fullActionInstance(request, clzAction, actionInstance);
        //3.调用action的处理方法
        Method actionMethod = clzAction.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        //4.根据返回结果跳转(转发)
        String result = (String) actionMethod.invoke(actionInstance, request, response);
        if (result != null) {
            request.getRequestDispatcher(result).forward(request, response);
        }
    }

    /**
     * 给Action对象的属性赋值
     */
    private void fullActionInstance(HttpServletRequest request,
                                    Class<?> clzAction, Object actionInstance)
            throws NoSuchFieldException, InstantiationException,
            IllegalAccessException {
        Map<String, Object> objFieldMap = new HashMap<String, Object>();
        @SuppressWarnings("unchecked")
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String attributeName = enums.nextElement();
            String attributeValue = request.getParameter(attributeName);
            System.out.println("表单属性名称：" + attributeName);
            //①.给action的对象属性赋值
            if (attributeName.contains(".")) {
                String[] temp = attributeName.split("\\.");
                Field field = clzAction.getDeclaredField(temp[0]);
                Class<?> clzObjField = field.getType();//对象属性
                if (objFieldMap.get(temp[0]) == null) {
                    Object o = clzObjField.newInstance();
                    objFieldMap.put(temp[0], o);
                }
                Object obj = objFieldMap.get(temp[0]);
                //把值赋给对象属性
//                ReflectionUtils.setFieldValue(obj, temp[1], attributeValue);
                //把对象属性赋给action
//                ReflectionUtils.setFieldValue(actionInstance, temp[0], obj);
                //②.给action的普通属性赋值
            } else {
//                ReflectionUtils.setFieldValue(actionInstance, attributeName, attributeValue);
            }
        }
    }

    /**
     * 得到action的全类名和方法名
     */
    private String[] getActionAndMethodName(HttpServletRequest request) {
        //得到请求的uri
        String uriName = request.getRequestURI();
        //得到最后一次出现/的下标
        int index = uriName.lastIndexOf('/');
        //从/后面截取到最后
        String href = uriName.substring(index + 1);
        //UserAction_addUser.action
        String[] arr = href.split("_");
        return arr;
    }

}
