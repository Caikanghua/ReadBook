package com.readbook.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * ȫ���쳣������
 * @author dell
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse reponse, Object handler,
			Exception ex) {
		//��ӡ������̨
		ex.printStackTrace();
		logger.error("ϵͳ�����쳣"+ex);
//		System.out.println("error");
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.addObject("message","ϵͳ����,������!");
//		modelAndView.setViewName("error/exception");
		return null;
	}
}

