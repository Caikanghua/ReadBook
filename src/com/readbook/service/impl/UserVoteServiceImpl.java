package com.readbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.UserVoteMapper;
import com.readbook.pojo.UserVote;
import com.readbook.service.UserVoteService;

@Service
public class UserVoteServiceImpl implements UserVoteService{
	@Autowired
	private UserVoteMapper mapper;
	@Override
	public void incUserVoteTimes(String userId) {
		mapper.incUserVoteTimes(Integer.parseInt(userId));
	}
	@Override
	public int selectVoteTimes(String userId) {
		UserVote userVote = mapper.selectByPrimaryKey(userId);
		return userVote.getVoteTimes();
	}
}
