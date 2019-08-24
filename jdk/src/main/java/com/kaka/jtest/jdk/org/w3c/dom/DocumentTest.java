package com.kaka.jtest.jdk.org.w3c.dom;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author: jsk
 * @date: 2019/8/14 16:15
 */
public class DocumentTest {
    @Test
    public void getChildNodesTest() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.parse("src/main/resources/test.xml");
        System.out.println(document.getChildNodes().item(0).getNodeName());
        System.out.println(document.getDocumentElement());
    }
}
