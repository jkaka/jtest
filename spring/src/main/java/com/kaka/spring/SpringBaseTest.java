package com.kaka.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 19:36
 */
public class SpringBaseTest {
	protected BeanFactory xmlBeanFactory;

	@Before
	public void before(){
		Resource classPathResource = new ClassPathResource("applicationContext.xml");
		xmlBeanFactory = new XmlBeanFactory(classPathResource);
	}
}
