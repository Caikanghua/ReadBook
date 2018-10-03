package com.readbook.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.mapper.RbBookMapper;
import com.readbook.pojo.RbBook;

public class TestSeachBook {
	
	@Test
	public void testSearchBook(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbBookMapper mapper = classPath.getBean(RbBookMapper.class);
		List<RbBook> list = mapper.searchBookByKey("java", 0, 4);
//		System.out.println(list.get(0).getAuthor());
		System.out.println(list.get(0).getPubHouse());
	}
}
