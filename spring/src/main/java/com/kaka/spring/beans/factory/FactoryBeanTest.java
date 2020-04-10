package com.kaka.spring.beans.factory;

import com.kaka.spring.SpringBaseTest;
import com.kaka.spring.pojo.factorybean.MyFactoryBean;
import com.kaka.spring.pojo.Person;
import com.kaka.spring.pojo.circular.TestA;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 19:36
 */
public class FactoryBeanTest extends SpringBaseTest {

	/**
	 * 普通bean
	 */
	@Test
	public void getBean(){
		Person myPerson = xmlBeanFactory.getBean("person", Person.class);
		System.out.println(myPerson);
	}

	/**
	 * 工厂bean
	 */
	@Test
	public void factoryBeanTest(){
		// 获取工厂bean的getObject()方法返回的实例
		Person myPerson = xmlBeanFactory.getBean("myPersonFactoryBean", Person.class);
		System.out.println(myPerson);

		// 获取工厂bean本身
		MyFactoryBean bean = xmlBeanFactory.getBean("&myPersonFactoryBean", MyFactoryBean.class);
		System.out.println(bean);
	}

	/**
	 * 循环依赖
	 */
	@Test
	public void circular(){
		TestA testA = xmlBeanFactory.getBean("testA", TestA.class);
		System.out.println(testA);
	}

	/**
	 * 工厂方法创建bean
	 */
	@Test
	public void factoryMethod(){
		Person personByFactory = xmlBeanFactory.getBean("personByFactory", Person.class);
		System.out.println(personByFactory);

		Person staticPerson = xmlBeanFactory.getBean("staticPerson", Person.class);
		System.out.println(staticPerson);

	}
}
