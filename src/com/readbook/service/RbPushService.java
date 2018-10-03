package com.readbook.service;

import com.readbook.pojo.RbPush;

public interface RbPushService {

	void addRbPush(RbPush rbPush);

	void deletePushById(int pushId);

}
