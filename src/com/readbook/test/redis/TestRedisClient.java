package com.readbook.test.redis;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.utils.JedisClient;
import com.readbook.utils.JedisClientPool;

public class TestRedisClient {
	
	@Test
	public void testRedisClient(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		JedisClient bean = context.getBean(JedisClientPool.class);
//		bean.incr("post:"+123);
//		bean.incr("post:"+123);
//		bean.incr("post:"+123);
		Long ttl = bean.ttl("token:12345678");
		System.out.println(ttl/(60*60));
	}
}
