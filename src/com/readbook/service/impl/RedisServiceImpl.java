package com.readbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.readbook.pojo.VoteBook;
import com.readbook.service.RedisService;
import com.readbook.utils.JedisClient;
import com.readbook.utils.JsonUtils;
/**
 * redisServiceʵ����
 * @author ckh
 * @date 2018-4-21 ����10:53:37
 */
@Service
public class RedisServiceImpl implements RedisService {
	@Autowired
	JedisClient jedisClient;
	/**
	 * ����ֻ���֤�뻺��
	 */
	@Override
	public void addVerifyCode(String string, String random) {
		jedisClient.set(string, random);
		//����redis isValidKey����ʱ�䣬ΪһСʱ
	}
	/**
	 * ��ȡ�ֻ���֤��
	 */
	@Override
	public String getVerifyCode(String string) {
		String hget = jedisClient.get(string);
		return hget;
	}
	/**
	 * ����û���½�����ɵ�token
	 */
	@Override
	public void addLoginToken(String tokenAndId, String token) {
		jedisClient.set(tokenAndId, token);
		//ɾ����֤�뻺��
		jedisClient.del("verifycode:"+tokenAndId.substring(6));
		//���õ�½tokenһ���¹���ʱ��
		jedisClient.expire(tokenAndId,3600*24*30);
	}
	@Override
	public String getLoginToken(String string) {
		String hget = jedisClient.get(string);
		return hget;
	}
	@Override
	public void deleteLoginToken(String string) {
		// �û�ѡ���˳���¼ʱ��ɾ����½token
		jedisClient.del(string);
	}
	@Override
	public void incVoteBook(String string) {
		jedisClient.incr(string);
	}
	@Override
	public void incUserVoteTimes(String string) {
		// �ж��û�ͶƱ�Ƿ�ﵽ��9Ʊ����������ù���ʱ��Ϊһ��
		String voteTimes = jedisClient.get(string);
		if (voteTimes != null && "9".equals(voteTimes)) {
			//���ù���ʱ��
			jedisClient.expire(string, 3600*24);
		}
		jedisClient.incr(string);
	}
	@Override
	public String getUserVoteTimes(String string) {
		return jedisClient.get(string);
	}
	@Override
	public boolean getVoteAction(String string) {
		boolean result = jedisClient.exists(string);
		return result;
	}
	@Override
	public boolean getVoteEnd(String string) {
		return jedisClient.exists(string);
	}
	@Override
	public void openVoteBook(String string) {
		jedisClient.set(string, "1");
	}
	@Override
	public void closeVoteBook(String string) {
		jedisClient.set(string, "2");
	}
	@Override
	public void againVoteBook(String string) {
		jedisClient.set(string, "1");
	}
	@Override
	public String getVoteState(String string) {
		String result = jedisClient.get(string);
		if(result==null||"".equals(result)){
			//δ����
			return "0";
		}else{
			return result;
		}
	}
	@Override
	public void addVoteBookList(List<VoteBook> list) {
		// ����ʵ�ַ���
		int size = list.size();
		for (int i = 0; i < size; i++) {
			jedisClient.hset("voteBooks", String.valueOf(list.get(i).getVoteBookId()), JsonUtils.objectToJson(list.get(i)));
		}
//		jedisClient.set("voteBooks", JsonUtils.objectToJson(list));
	}
	@Override
	public List<VoteBook> getVoteBooks() {
		List<String> hvals = jedisClient.hvals("voteBooks");
		List<VoteBook> listResult = new ArrayList<VoteBook>();
		for (int i = 0; i < hvals.size(); i++) {
			listResult.add(JsonUtils.jsonToPojo(hvals.get(i), VoteBook.class));
		}
//		String string = jedisClient.get("voteBooks");
//		List<VoteBook> list = JsonUtils.jsonToList(string, VoteBook.class);
//		return list;
		return listResult;
	}
	@Override
	public void addTimeSlot(String string, String timeSlot) {
		jedisClient.set(string, timeSlot);
	}
	@Override
	public String getSlotTimeByRId(String reservationId) {
		String string = jedisClient.get("timeSlot:"+reservationId);
		return string;
	}
	@Override
	public void addShareSendTime(String string, String slotTime) {
		jedisClient.set(string, slotTime);
	}
	@Override
	public void deleteByKey(String string) {
		jedisClient.del(string);
	}
	@Override
	public String getSlotTimeBySId(String shareId) {
		String result = jedisClient.get("share:"+shareId);
		return result;
	}
	@Override
	public void incVoteBookVotes(VoteBook voteBook) {
		jedisClient.hset("voteBooks", String.valueOf(voteBook.getVoteBookId()), JsonUtils.objectToJson(voteBook));
	}
	@Override
	public VoteBook getVoteBookById(String voteBookId) {
		String hget = jedisClient.hget("voteBooks", voteBookId);
		return JsonUtils.jsonToPojo(hget, VoteBook.class);
	}
}
