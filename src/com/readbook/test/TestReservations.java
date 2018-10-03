package com.readbook.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.mapper.RbReservationMapper;
import com.readbook.pojo.RbReservation;

public class TestReservations {
	@Test
	public void testReservation(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbReservationMapper mapper = classPath.getBean(RbReservationMapper.class);
		String state= mapper.getStateById("13567");
		System.out.println(state);
	}
}
