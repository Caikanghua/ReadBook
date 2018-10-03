package com.readbook.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.mapper.RbBookMapper;
import com.readbook.pojo.RbBook;

public class TestGetBooks {
	
	@Test
	public void getBooksTest(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbBookMapper mapper = classPath.getBean(RbBookMapper.class);
		List<RbBook> rbBookList = mapper.getBooksByCondition(1, 0, 4);
		System.out.println(rbBookList.size());
		for (RbBook rbBook : rbBookList) {
			System.out.println(rbBook.getAuthor());
			System.out.println("ΩË‘ƒ¡ø:"+rbBook.getReadCnt());
		}
	}
}
