package com.kaka.spring.beans.factory;

import com.kaka.spring.SpringBaseTest;
import com.kaka.spring.pojo.MyFactoryBean;
import com.kaka.spring.pojo.Person;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 19:36
 */
public class FactoryBeanTest extends SpringBaseTest {

	/**
	 * 获取工厂bean的getObject()方法返回的实例
	 */
	@Test
	public void getBean(){
		Person myPerson = xmlBeanFactory.getBean("myPerson", Person.class);
		System.out.println(myPerson);
		myPerson = xmlBeanFactory.getBean("myPerson", Person.class);
		System.out.println(myPerson);
	}

	/**
	 * 获取工厂bean本身
	 */
	@Test
	public void getFactoryBean(){
		MyFactoryBean bean = xmlBeanFactory.getBean("&myPerson", MyFactoryBean.class);
		System.out.println(bean);
	}
}
