package com.readbook.service.impl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbPushMapper;
import com.readbook.pojo.RbPush;
import com.readbook.service.RbPushService;
@Service
public class RbPushServiceImpl implements RbPushService {
	@Autowired
	private RbPushMapper rbPushMapper;
	@Override
	public void addRbPush(RbPush rbPush) {
		rbPush.setDate(new Date());
		rbPushMapper.insertSelective(rbPush);
	}
	@Override
	public void deletePushById(int pushId) {
		rbPushMapper.deleteByPrimaryKey(pushId);
	}
}
