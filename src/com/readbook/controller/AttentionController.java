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
 * ��ע������
 * @author ckh
 * @date 2018-4-21 ����8:22:12
 */
@Controller
public class AttentionController {
	@Autowired
	private AttentionService attentionService;
	/**
	 * ��ע�û�
	 * @param attentionUserId
	 * @param beAttentionUserId
	 * @param request
	 * @return
	 */
	@RequestMapping("/attentionUser")
	@ResponseBody
	public RbResult attentionUser(String attentionUserId,String beAttentionUserId,HttpServletRequest request) {
		if (attentionUserId.equals(beAttentionUserId)) {
			return RbResult.build(-400, "�Լ����ܹ�ע�Լ�");
		}
		boolean isAttention = attentionService.checkAttention(attentionUserId,beAttentionUserId);
		if (isAttention) {
			return RbResult.build(-200, "���Ѿ���ע�˸��û��������ظ���ע");
		}
		boolean beyondNum = attentionService.checkAttentionNum(attentionUserId);
		if (beyondNum) {
			// ��ע�û���������10��
			return RbResult.build(-102, "����ע���û������Ѿ���������ֵ�������ٹ�ע");
		}
		attentionService.attention(attentionUserId,beAttentionUserId);
		return RbResult.ok();
	}
	/**
	 * ȡ���û���ע
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
	 * ��ȡ�û���ע���û���Ϣ
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
