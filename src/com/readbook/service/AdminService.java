package com.readbook.service;

import java.util.Map;

import com.readbook.pojo.Admin;

public interface AdminService {

	Map<String, Object> adminLogin(String username, String password);

	void addAdmin(Admin admin);

	void updateAdminPassword(String adminId, String md5DigestAsHex);

	boolean checkAdmin(Admin admin);
	
}
