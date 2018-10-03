package com.readbook.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * 全局异常处理器
 * @author dell
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse reponse, Object handler,
			Exception ex) {
		//打印到控制台
		ex.printStackTrace();
		logger.error("系统发生异常"+ex);
//		System.out.println("error");
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.addObject("message","系统出错,请重试!");
//		modelAndView.setViewName("error/exception");
		return null;
	}
}

