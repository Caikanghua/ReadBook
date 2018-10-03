package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.AttentionMapper;
import com.readbook.pojo.Attention;
import com.readbook.pojo.AttentionExample;
import com.readbook.pojo.AttentionExample.Criteria;
import com.readbook.pojo.RbUser;
import com.readbook.service.AttentionService;
@Service
public class AttentionServiceImpl implements AttentionService {
	@Autowired
	private AttentionMapper mapper;
	@Override
	public void attention(String attentionUserId, String beAttentionUserId) {
		Attention attention = new Attention();
		attention.setAttentionUser(attentionUserId);
		attention.setBeAttentionUser(beAttentionUserId);
		mapper.insertSelective(attention);
	}
	@Override
	public void cancleAttention(String attentionUserId, String beAttentionUserId) {
		AttentionExample example = new AttentionExample();
		Criteria criteria = example.createCriteria();
		criteria.andAttentionUserEqualTo(attentionUserId);
		criteria.andBeAttentionUserEqualTo(beAttentionUserId);
		mapper.deleteByExample(example);
	}
	@Override
	public boolean checkAttention(String attentionUserId,
			String beAttentionUserId) {
		AttentionExample example = new AttentionExample();
		Criteria criteria = example.createCriteria();
		criteria.andAttentionUserEqualTo(attentionUserId);
		criteria.andBeAttentionUserEqualTo(beAttentionUserId);
		List<Attention> list = mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkAttentionNum(String attentionUserId) {
		AttentionExample example = new AttentionExample();
		Criteria criteria = example.createCriteria();
		criteria.andAttentionUserEqualTo(attentionUserId);
		int count = mapper.countByExample(example);
		if (count >= 10) {
			return true;
		}
		return false;
	}
	@Override
	public List<RbUser> getAllAttention(String userId) {
		List<RbUser> list = mapper.selectAllAttention(userId);
		return list;
	}
	@Override
	public List<String> getAllUserId(String beAttentionUser) {
		List<String> list = mapper.getAllUserId(beAttentionUser);
		return list;
	}
}
