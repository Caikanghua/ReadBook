package com.readbook.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.readbook.mapper.RbPostMapper;
import com.readbook.mapper.RbReservationMapper;
import com.readbook.mapper.RbShareMapper;
import com.readbook.mapper.RbUserMapper;
import com.readbook.mapper.RbUsercommentMapper;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbReservationExample;
import com.readbook.pojo.RbShare;
import com.readbook.pojo.RbUser;
import com.readbook.pojo.RbUserExample;
import com.readbook.pojo.RbUserExample.Criteria;
import com.readbook.pojo.RbUsercomment;
import com.readbook.pojo.RbUsercommentExample;
import com.readbook.service.UserService;
import com.readbook.utils.RbResult;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private RbUserMapper rbUserMapper;
	@Autowired
	private RbReservationMapper rbReservationMapper;
	@Autowired
	private RbShareMapper rbShareMapper;
	@Autowired
	private RbPostMapper rbPostMapper;
	@Autowired
	private RbUsercommentMapper rbUsercommentMapper;
	@Override
	public void register(RbUser rbUser) {
		rbUserMapper.insertSelective(rbUser);
	}
	@Override
	public Map<String,Object> userLogin(String phone, String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		RbUserExample rbUserExample = new RbUserExample();
		Criteria criteria = rbUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<RbUser> rbUserList = rbUserMapper.selectByExample(rbUserExample);
		if(rbUserList==null||rbUserList.size()==0){
			map.put("statusCode", 400);
			map.put("message", "用户账户或密码错误");
			return map;
		}
		RbUser rbUser = rbUserList.get(0);
		//判断密码是否相同
		password=DigestUtils.md5DigestAsHex(password.getBytes());
		if(password==null||!password.equals(rbUser.getPassword())){
			map.put("statusCode", 400);
			map.put("message", "用户账户或密码错误");
			return map;
		}
		//更新最近一次登陆时间
		rbUser.setLoginTime(new Date());
		rbUserMapper.updateByPrimaryKeySelective(rbUser);
		//返回数据
		Map<String,String> mapData=new HashMap<String,String>();
		String token =UUID.randomUUID().toString();
		String userId =rbUser.getUserId();
		mapData.put("token", token);
		mapData.put("userId", userId);
		map.put("statusCode", "102");
		map.put("message", "success");
		map.put("result", mapData);
		return map;
	}
	@Override
	public RbUser getUserInfo(String userId) {
		RbUser rbUser = rbUserMapper.selectByPrimaryKey(userId);
		rbUser.setPassword(null);
		return rbUser;
	}
	@Override
	public void updateUserInfo(RbUser user) {
		rbUserMapper.updateByPrimaryKeySelective(user);
	}
	/**
	 * 根据用户id查找用户
	 */
	@Override
	public RbUser selectUserById(String userId) {
		RbUser rbUser = rbUserMapper.selectByPrimaryKey(userId);
		return rbUser;
	}
	/**
	 * 用户预约书分页
	 */
	@Override
	public List<RbReservation> getUserReservations(String userId, int state,
			int stu_num, int page_size) {
		List<RbReservation> list = rbReservationMapper.getRbservationsByCondition(userId, state, stu_num, page_size);
		return list;
	}
	/**
	 * 查询用户分享过的书
	 */
	@Override
	public List<RbShare> getUserShares(String userId, int state, int stu_num,
			int page_size) {
		List<RbShare> list=rbShareMapper.findUserSharesByCondition(userId,state,stu_num,page_size);
		return list;
	}
	@Override
	public List<RbPost> getUserPostsByCondition(String userId, String rankby,
			int stu_num, int page_size) {
		List<RbPost> list=rbPostMapper.getUserPostsByCondition(userId,rankby,stu_num,page_size);
		list=getAllComments(list);
		return list;
	}
	//获取用户一个书评的所有评论
	private List<RbPost> getAllComments(List<RbPost> list) {
		//获取用户对书评的评价
		for (RbPost rbPost : list) {
			List<RbUsercomment> commentList = rbPost.getCommentList();
			getAllCommentsByComment(commentList);
			
		}
		return list;
	}
	//获取对一个评论进行评论的所有评论
	private void getAllCommentsByComment(List<RbUsercomment> commentList) {
//		if(commentList!=null&&commentList.size()>0){
//			for (RbUsercomment rbUsercomment : commentList) {
//				if(rbUsercomment!=null){
//					String uCommentId = rbUsercomment.getuCommentId();
//					String uCommentId=rbUsercomment.getToCommentId();
//					if(uCommentId!=null){
//						//获取对该评论的的所有评论
//						RbUsercommentExample example=new RbUsercommentExample();
//						com.readbook.pojo.RbUsercommentExample.Criteria createCriteria = example.createCriteria();
//						createCriteria.andToCommentIdEqualTo(uCommentId);
//						List<RbUsercomment> comments = rbUsercommentMapper.selectByExampleWithBLOBs(example);
//						if(comments!=null){
//							rbUsercomment.setRbUserComments(comments);
//							getAllCommentsByComment(comments);
//						}else{
//							break;
//						}
//					}
//				}
//			}
//		}
		
	}
	@Override
	public void updateReadCnt(String userId) {
		rbUserMapper.updateReadCnt(userId);
	}
	@Override
	public void updateShareCntInc(String userId) {
		rbUserMapper.updateShareCntInc(userId);
	}
	@Override
	public void lock(String userId, String type) {
		rbUserMapper.lock(userId,type);
	}
	@Override
	public boolean checkStuNum(String studentNum) {
		RbUserExample example=new RbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStuNumEqualTo(studentNum);
		List<RbUser> list = rbUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public String getStuNumById(String userId) {
		RbUser rbUser = rbUserMapper.selectByPrimaryKey(userId);
		return rbUser.getStuNum();
	}
	@Override
	public boolean checkPhoneRegister(String phone) {
		RbUserExample example=new RbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<RbUser> list = rbUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public List<RbReservation> getUserAllReservations(String userId,
			int stu_num, int page_size) {
		List<RbReservation> list = rbReservationMapper.getAllRbservations(userId,stu_num, page_size);
		return list;
	}
	@Override
	public List<RbShare> getUserAllShares(String userId, int start_num,
			int page_size) {
		List<RbShare> list=rbShareMapper.getUserAllShares(userId,start_num,page_size);
		return list;
	}
	@Override
	public String getUserNickNameById(String userId) {
		String nickName=rbUserMapper.getUserNickName(userId);
		return nickName;
	}
	@Override
	public RbUser getUserByPhone(String phone) {
		RbUserExample example=new RbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<RbUser> select = rbUserMapper.selectByExample(example);
		if(select!=null&&select.size()>0){
			return select.get(0);
		}
		return null;
	}
	@Override
	public RbUser getUserPartDetail(String userId) {
		RbUser user = rbUserMapper.getUserPartDetailByUserId(userId);
		return user;
	}
}
