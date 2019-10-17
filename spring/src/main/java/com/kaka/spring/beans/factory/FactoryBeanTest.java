package com.kaka.spring.beans.factory;

import com.kaka.spring.SpringBaseTest;
import com.kaka.spring.pojo.Person;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 19:36
 */
public class FactoryBeanTest extends SpringBaseTest {

	@Test
	public void getFactoryBean(){
		Person myPerson = xmlBeanFactory.getBean("myPerson", Person.class);
		System.out.println(myPerson);
	}
}
