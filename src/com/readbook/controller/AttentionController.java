package com.readbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.rmi.transport.proxy.HttpReceiveSocket;

import com.readbook.pojo.RbUser;
import com.readbook.service.AttentionService;
import com.readbook.utils.RbResult;
import com.sun.jersey.api.core.HttpRequestContext;
/**
 * 关注控制类
 * @author ckh
 * @date 2018-4-21 上午8:22:12
 */
@Controller
public class AttentionController {
	@Autowired
	private AttentionService attentionService;
	/**
	 * 关注用户
	 * @param attentionUserId
	 * @param beAttentionUserId
	 * @param request
	 * @return
	 */
	@RequestMapping("/attentionUser")
	@ResponseBody
	public RbResult attentionUser(String attentionUserId,String beAttentionUserId,HttpServletRequest request) {
		if (attentionUserId.equals(beAttentionUserId)) {
			return RbResult.build(-400, "自己不能关注自己");
		}
		boolean isAttention = attentionService.checkAttention(attentionUserId,beAttentionUserId);
		if (isAttention) {
			return RbResult.build(-200, "您已经关注了该用户，无需重复关注");
		}
		boolean beyondNum = attentionService.checkAttentionNum(attentionUserId);
		if (beyondNum) {
			// 关注用户数量超过10个
			return RbResult.build(-102, "您关注的用户数量已经超过限制值，不能再关注");
		}
		attentionService.attention(attentionUserId,beAttentionUserId);
		return RbResult.ok();
	}
	/**
	 * 取消用户关注
	 * @param attentionUserId
	 * @param beAttentionUserId
	 * @param request
	 * @return
	 */
	@RequestMapping("/cancleAttention")
	@ResponseBody
	public RbResult cancleAttention(String attentionUserId,String beAttentionUserId,HttpServletRequest request) {
		attentionService.cancleAttention(attentionUserId,beAttentionUserId);
		return RbResult.ok();
	}
	/**
	 * 获取用户关注的用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getAllAttention")
	@ResponseBody
	public RbResult getAllAttention(String userId,HttpServletRequest request) {
		List<RbUser> list = attentionService.getAllAttention(userId);
		return RbResult.ok(list);
	}
	
}
