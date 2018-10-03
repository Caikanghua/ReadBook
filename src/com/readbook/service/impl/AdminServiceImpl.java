package com.readbook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.readbook.mapper.AdminMapper;
import com.readbook.pojo.Admin;
import com.readbook.pojo.AdminExample;
import com.readbook.pojo.AdminExample.Criteria;
import com.readbook.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	@Override
	public Map<String, Object> adminLogin(String username, String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		AdminExample example=new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Admin> adminList = adminMapper.selectByExample(example);
		if(adminList==null||adminList.size()==0){
			map.put("statusCode", 400);
			map.put("message", "用户账户或密码错误");
			return map;
		}
		Admin admin = adminList.get(0);
		//判断密码是否相同
		if(password==null||!password.equals(admin.getPassword())){
			map.put("statusCode", 400);
			map.put("message", "用户账户或密码错误");
			return map;
		}
		Map<String,String> mapData=new HashMap<String,String>();
		String token =UUID.randomUUID().toString();
		String adminId =admin.getAdminId();
		mapData.put("token", token);
		mapData.put("adminId", adminId);
		map.put("statusCode", "102");
		map.put("message", "success");
		map.put("result", mapData);
		return map;
	}
	@Override
	public void addAdmin(Admin admin) {
		adminMapper.insertSelective(admin);
	}
	@Override
	public void updateAdminPassword(String adminId, String md5DigestAsHex) {
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setPassword(md5DigestAsHex);
		adminMapper.updateByPrimaryKeySelective(admin);
	}
	@Override
	public boolean checkAdmin(Admin admin) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(admin.getUsername());
		List<Admin> list = adminMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

}
