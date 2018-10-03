package com.readbook.service;

import java.util.List;
import java.util.Map;

import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbShare;
import com.readbook.pojo.RbUser;
import com.readbook.utils.RbResult;

public interface UserService {
	//зЂВс
	public void register(RbUser rbUser);

	public Map<String,Object> userLogin(String phone, String password);

	public RbUser getUserInfo(String userId);

	public void updateUserInfo(RbUser user);

	public RbUser selectUserById(String userId);


	public List<RbReservation> getUserReservations(String userId, int i,
			int stu_num, int page_size);

	public List<RbShare> getUserShares(String userId, int i, int stu_num,
			int page_size);

	public List<RbPost> getUserPostsByCondition(String userId, String rankby,
			int stu_num, int page_size);

	public void updateReadCnt(String userId);

	public void updateShareCntInc(String userId);

	public void lock(String userId, String type);

	public boolean checkStuNum(String studentNum);

	public String getStuNumById(String userId);

	public boolean checkPhoneRegister(String phone);

	public List<RbReservation> getUserAllReservations(String userId,
			int stu_num, int page_size);

	public List<RbShare> getUserAllShares(String userId, int stu_num,
			int page_size);

	public String getUserNickNameById(String userId);

	public RbUser getUserByPhone(String phone);

	public RbUser getUserPartDetail(String userId);
}
