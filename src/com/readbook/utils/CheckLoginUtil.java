package com.readbook.utils;

import javax.servlet.http.HttpServletRequest;

import com.readbook.service.RedisService;

/**
 * ��֤�û��Ƿ��½
 * @author caikanghua
 *
 */
public class CheckLoginUtil {
	public static boolean checkLogin(HttpServletRequest request,RedisService redisService) {
		//��ȡ�û�����ͷ��Ϣ
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
				//�ѵ�¼
				return true;
			}else{
				return false;
			}
		}
	}

}
