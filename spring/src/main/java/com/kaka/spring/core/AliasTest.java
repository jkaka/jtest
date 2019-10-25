package com.kaka.spring.core;

import com.kaka.spring.SpringBaseTest;
import com.kaka.spring.pojo.Person;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-15 15:21
 */
public class AliasTest extends SpringBaseTest {

	/**
	 * 通过别名获取到的是同一个对象
	 * 别名信息保存在：SimpleAliasRegistry#aliasMap
	 */
	@Test
	public void alias() {
		Person personAlias01 = (Person) xmlBeanFactory.getBean("personAlias01");
		Person person = (Person) xmlBeanFactory.getBean("person");
		System.out.println(person == personAlias01);
	}
}
