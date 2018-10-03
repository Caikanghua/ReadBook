package com.readbook.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.mapper.RbBookMapper;

public class TestBookStock {
	@Test
	public void testBookStock(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbBookMapper bean = classPath.getBean(RbBookMapper.class);
		String isStock = bean.checkIsStock("123");
		System.out.println(isStock);
	}
}
