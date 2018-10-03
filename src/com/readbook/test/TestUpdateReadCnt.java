package com.readbook.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.mapper.RbBookMapper;
import com.readbook.mapper.RbReservationMapper;
import com.readbook.mapper.RbUserMapper;
import com.readbook.pojo.RbReservation;

public class TestUpdateReadCnt {
	
	@Test
	public void testUpdateReadCnt(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
//		RbBookMapper mapper = classPath.getBean(RbBookMapper.class);
//		mapper.updateReadCntInc("123");
//		RbReservation rb=new RbReservation();
//		rb.setReservationId("13567");
//		rb.setState(1);
		RbUserMapper mapper = classPath.getBean(RbUserMapper.class);
		mapper.updateReadCnt("123");
		
	}
}
