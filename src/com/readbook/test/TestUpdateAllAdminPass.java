package com.readbook.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

import com.readbook.mapper.AdminMapper;
import com.readbook.pojo.Admin;
import com.readbook.pojo.AdminExample;

public class TestUpdateAllAdminPass {
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		AdminMapper mapper = context.getBean(AdminMapper.class);
		AdminExample example = new AdminExample();
		List<Admin> list = mapper.selectByExample(example);
		for (Admin admin : list) {
			admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		}
		for (Admin admin : list) {
			mapper.updateByPrimaryKey(admin);
		}
	}
}
