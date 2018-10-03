package com.readbook.service;

public interface UserVoteService {

	void incUserVoteTimes(String userId);

	int selectVoteTimes(String userId);

}
