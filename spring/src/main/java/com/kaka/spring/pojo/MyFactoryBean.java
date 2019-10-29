package com.kaka.spring.pojo;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 19:28
 */
@Data
public class MyFactoryBean implements FactoryBean<Person> {
	private String personInfo;
	@Override
	public Person getObject() throws Exception {
		System.out.println("调用factoryBean的getObject()方法...");
		Person person = new Person();
		person.setName("factoryBean");
		person.setNickName(personInfo);
		return person;
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	public String getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(String personInfo) {
		this.personInfo = personInfo;
	}
}
