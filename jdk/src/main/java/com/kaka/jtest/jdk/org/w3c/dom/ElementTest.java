package com.kaka.jtest.jdk.org.w3c.dom;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author: jsk
 * @date: 2019/8/25 21:51
 */
public class ElementTest {

    private Element rootElement;

    @Before
    public void before() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.parse("src/main/resources/test.xml");
        rootElement = document.getDocumentElement();
    }

    /**
     * 获取节点标签名称
     */
    @Test
    public void getTagNameTest() {
        System.out.println(rootElement.getTagName());
        System.out.println(rootElement.getNodeName());
    }

    /**
     * 获取该标签上的属性值
     */
    @Test
    public void getAttributeTest() {
        System.out.println(rootElement.getAttribute("debug"));
        // 返回空字符串
        System.out.println(rootElement.getAttribute("debug1"));
    }

}
