package com.readbook.utils;

import javax.servlet.http.HttpServletRequest;

import com.readbook.service.RedisService;

/**
 * 验证用户是否登陆
 * @author caikanghua
 *
 */
public class CheckLoginUtil {
	public static boolean checkLogin(HttpServletRequest request,RedisService redisService) {
		//获取用户请求头信息
		String keyUser = request.getHeader("x-key");
		String tokenUser = request.getHeader("x-token");
		if(StringUtils.isBlank(keyUser)||StringUtils.isBlank(tokenUser)){
			return false;
		}
		String token=redisService.getLoginToken("token:"+keyUser);
		if(StringUtils.isBlank(token)){
			return false;
		}else{
			if(tokenUser.equals(token)){
				//已登录
				return true;
			}else{
				return false;
			}
		}
	}

}
