package com.readbook.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDateAnalysis {
	
	@Test
	public void testDate(){
//		Date date=new Date("2018-06-19");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = format.format(new Date());
		String m = str.substring(5, 7);
		System.out.println(str.substring(8,10));
		System.out.println("–° ±:"+str.substring(11, 13));
		System.out.println("∑÷÷”:"+str.substring(14, 16));
		System.out.println(m);
	}
}
