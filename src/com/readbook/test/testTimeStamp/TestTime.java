package com.readbook.test.testTimeStamp;

import java.util.Date;

import org.junit.Test;

public class TestTime {
	
	@Test
	public void test() throws InterruptedException{
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long day = date2.getTime() - date1.getTime();
		System.out.println(day);
	}
}
