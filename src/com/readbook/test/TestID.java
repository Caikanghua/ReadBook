package com.readbook.test;

import org.junit.Test;

public class TestID {
	
	@Test
	public void testId(){
		long millis = System.currentTimeMillis();
		System.out.println(millis%100);
	}
}
