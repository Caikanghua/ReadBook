package com.readbook.service;

import com.readbook.pojo.RbUserprotocol;

public interface RbUserProtocolService {

	void addUserProtocol(String userProtocol);

	RbUserprotocol getProtocol();

	void updateUserProtocol(String userProtocol);

	boolean checkProtocol();

}
