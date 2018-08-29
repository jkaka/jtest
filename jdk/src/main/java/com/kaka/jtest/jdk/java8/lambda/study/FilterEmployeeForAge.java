package com.kaka.jtest.jdk.java8.lambda.study;

/**
 * 策略类
 */
public class FilterEmployeeForAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}

}
