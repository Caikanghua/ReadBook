package com.readbook.test;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.readbook.mapper.RbUserMapper;
import com.readbook.pojo.RbUser;
import com.readbook.service.UserService;
import com.readbook.utils.RbResult;

public class TestUserMapper {
	@Test
	public void testInsert(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbUserMapper bean = classPath.getBean(RbUserMapper.class);
		RbUser rbUser=new RbUser();
		rbUser.setUserId(UUID.randomUUID().toString());
		rbUser.setCollege("信息工程");
		rbUser.setIsLegal(true);
		rbUser.setPhone("123");
		rbUser.setName("蔡康华");
		rbUser.setStuNum("2015130021");
		rbUser.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
		rbUser.setRegisterTime(new Date());
		bean.insert(rbUser);
	}
	@Test
	public void testLogin(){
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring.xml");
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		UserService bean = application.getBean(UserService.class);
		Map<String, Object> userLogin = bean.userLogin("18129857238", "123456");
		Map<String,Object> object = (Map<String, Object>) userLogin.get("result");
		String userId = (String) object.get("userId");
		String token = (String) object.get("token");
//		String tokenTest = (String) session.getAttribute("token:"+userId);
//		System.out.println(tokenTest+"    "+token);
	}
}
