package com.readbook.test;

import org.junit.Test;

public class TestImageName {
	
	@Test
	public void testImageName(){
		String str="sfsdf.jpg";
		System.out.println(str.substring(str.indexOf(".")));
	}
}
