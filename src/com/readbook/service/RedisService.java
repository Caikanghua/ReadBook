package com.readbook.service;

import java.util.List;

import com.readbook.pojo.VoteBook;

public interface RedisService {

	void addVerifyCode(String string, String random);

	String getVerifyCode(String string);

	void addLoginToken(String string, String object);

	String getLoginToken(String string);

	void deleteLoginToken(String string);

	void incVoteBook(String string);

	void incUserVoteTimes(String string);

	String getUserVoteTimes(String string);

	boolean getVoteAction(String string);

	boolean getVoteEnd(String string);

	void openVoteBook(String string);

	void closeVoteBook(String string);

	void againVoteBook(String string);

	String getVoteState(String string);

	void addVoteBookList(List<VoteBook> list);

	List<VoteBook> getVoteBooks();

	void addTimeSlot(String string, String timeSlot);

	String getSlotTimeByRId(String reservationId);

	void addShareSendTime(String string, String soltTime);

	void deleteByKey(String string);

	String getSlotTimeBySId(String shareId);

	void incVoteBookVotes(VoteBook voteBook);

	VoteBook getVoteBookById(String voteBookId);

}
