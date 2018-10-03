package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbUserprotocolMapper;
import com.readbook.pojo.RbUserprotocol;
import com.readbook.pojo.RbUserprotocolExample;
import com.readbook.pojo.RbUserprotocolExample.Criteria;
import com.readbook.service.RbUserProtocolService;
@Service
public class RbUserProtocolServiceImpl implements RbUserProtocolService {
	@Autowired
	private RbUserprotocolMapper mapper;
	@Override
	public void addUserProtocol(String userProtocol) {
		RbUserprotocol protocol=new RbUserprotocol();
		protocol.setUserProtocol(userProtocol);
		mapper.insertSelective(protocol);
	}
	@Override
	public RbUserprotocol getProtocol() {
		RbUserprotocolExample example=new RbUserprotocolExample();
		List<RbUserprotocol> list = mapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateUserProtocol(String userProtocol) {
		RbUserprotocolExample example=new RbUserprotocolExample();
		List<RbUserprotocol> list = mapper.selectByExampleWithBLOBs(example);
		RbUserprotocol protocol=list.get(0);
		protocol.setUserProtocol(userProtocol);
		mapper.updateByPrimaryKeyWithBLOBs(protocol);
	}
	@Override
	public boolean checkProtocol() {
		RbUserprotocol protocol = getProtocol();
		if(protocol!=null){
			return true;
		}
		return false;
	}
}
