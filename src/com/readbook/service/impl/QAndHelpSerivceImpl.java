package com.readbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbQandaMapper;
import com.readbook.pojo.RbQanda;
import com.readbook.pojo.RbQandaExample;
import com.readbook.service.QAndHelpSerivce;
@Service
public class QAndHelpSerivceImpl implements QAndHelpSerivce {
	@Autowired
	private RbQandaMapper rbQandaMapper;
	@Override
	public List<RbQanda> getHelps() {
		RbQandaExample example=new RbQandaExample();
		return rbQandaMapper.selectByExample(example);
	}
	@Override
	public void addQanda(RbQanda rbQanda) {
		rbQanda.setPushDate(new Date());
		rbQandaMapper.insertSelective(rbQanda);
	}
	@Override
	public void deleteHelpById(String helpId) {
		rbQandaMapper.deleteByPrimaryKey(Integer.parseInt(helpId));
	}

}
