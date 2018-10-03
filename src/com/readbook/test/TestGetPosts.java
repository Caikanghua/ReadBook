package com.readbook.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.readbook.mapper.RbPostMapper;
import com.readbook.mapper.RbUsercommentMapper;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbUsercomment;
import com.readbook.pojo.RbUsercommentExample;
import com.readbook.pojo.RbUsercommentExample.Criteria;
import com.readbook.service.UserService;
import com.readbook.service.impl.UserServiceImpl;

public class TestGetPosts {
	@Test
	public void testGetPosts(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbPostMapper postMapper = classPath.getBean(RbPostMapper.class);
//		List<RbPost> list = postMapper.getUserPostsByCondition("152144861729297","0",0,10);
		List<RbPost> list=postMapper.getPostsByType("0", "1", 0, 10);
		System.out.println("roPostµÄÊýÁ¿:"+list.size());
//		for (RbPost rbPost : list) {
//			List<RbUsercomment> commentList = rbPost.getCommentList();
//			System.out.println(commentList.size());
//			for (RbUsercomment rbUsercomment : commentList) {
//				String atName = rbUsercomment.getAtName();
//				System.out.println(atName);
//			}
//		}
	}
	@Test
	public void testGetCommentByComment(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		RbUsercommentMapper bean = classPath.getBean(RbUsercommentMapper.class);
		RbUsercommentExample example = new RbUsercommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andToCommentIdEqualTo("123");
		List<RbUsercomment> list = bean.selectByExample(example);
		System.out.println(list.size());
		
	}
	
	@Test
	public void getAllPostsComment(){
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("classpath:spring.xml");
		UserService bean = classPath.getBean(UserService.class);
//		List<RbPost> list = bean.getUserPostsByCondition("12","2", 0, 4);
//		System.out.println(list.size());
	}
	
}
