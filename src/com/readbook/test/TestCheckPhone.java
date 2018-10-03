package com.readbook.test;

import org.junit.Test;

import com.readbook.utils.CheckUtils;

public class TestCheckPhone {
	
	@Test
	public void testCheckPhone(){
		String phone="1815";
		boolean checkMobile = CheckUtils.checkMobile(phone);
		System.out.println(checkMobile);
	}
}
