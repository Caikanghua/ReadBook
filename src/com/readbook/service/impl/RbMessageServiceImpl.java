package com.readbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbMessageMapper;
import com.readbook.pojo.RbMessage;
import com.readbook.service.RbMessageService;
import com.readbook.utils.IDUtils;
@Service
public class RbMessageServiceImpl implements RbMessageService {
	@Autowired
	private RbMessageMapper messageMapper;
	@Override
	public void sendFeedbackMessage(String userId, String feedbackResult) {
		RbMessage message = new RbMessage();
		message.setMessageId(IDUtils.getId());
		message.setContent(feedbackResult);
		message.setUserId(userId);
		message.setDate(new Date());
		message.setMessageType("3");
		messageMapper.insertSelective(message);
	}
	@Override
	public void sendReportMessage(String userId) {
		RbMessage message = new RbMessage();
		message.setMessageId(IDUtils.getId());
		message.setContent("����Ͷ�ߵ�����/���ۣ����ͨ��������Ա�Ѿ�ɾ�����Υ������/���ۣ�лл����ƽ̨��֧��!");
		message.setUserId(userId);
		message.setDate(new Date());
		message.setMessageType("4");
		messageMapper.insertSelective(message);
	}
	@Override
	public void sendCheckSuccessMessage(String userId,String bookName) {
		RbMessage message = new RbMessage();
		message.setUserId(userId);
		message.setDate(new Date());
		message.setMessageType("0");
		message.setContent("��ԤԼ����:��"+bookName+"�����Ѿ�ͨ�����,��л����ƽ̨��֧��");
		message.setMessageId(IDUtils.getId());
		messageMapper.insertSelective(message);
	}
	@Override
	public void sendCheckFailMessage(String userId, String bookName) {
		RbMessage message = new RbMessage();
		message.setUserId(userId);
		message.setDate(new Date());
		message.setMessageType("1");
		message.setContent("��ԤԼ����:��"+bookName+"����û�����,��������������ԤԼ");
		message.setMessageId(IDUtils.getId());
		messageMapper.insertSelective(message);
	}
	@Override
	public void sendWishStorageMessage(String userId, String bookName) {
		RbMessage message = new RbMessage();
		message.setMessageId(IDUtils.getId());
		message.setDate(new Date());
		message.setContent("����Ը����:��"+bookName+"��,�Ѿ�����ˣ��Ͻ�ȥ����");
		message.setMessageType("2");
		message.setUserId(userId);
		messageMapper.insertSelective(message);
	}
	@Override
	public RbMessage getMessageDetailById(String messageId) {
		return messageMapper.selectByPrimaryKey(messageId);
	}
	@Override
	public void updateHasRead(String messageId) {
		RbMessage message = new RbMessage();
		message.setMessageId(messageId);
		message.setIsRead("1");
		messageMapper.updateByPrimaryKeySelective(message);
	}
	@Override
	public List<RbMessage> getUserAllMessage(String userId, String isRead,
			int start_num, int page_size) {
		List<RbMessage> list = messageMapper.getUserAllMessage(userId,isRead,start_num,page_size);
		return list;
	}
	@Override
	public void sendAttentionPost(RbMessage message) {
		messageMapper.insertSelective(message);
	}

}
