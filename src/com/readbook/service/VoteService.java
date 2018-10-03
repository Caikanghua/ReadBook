package com.readbook.service;

import java.util.List;

import com.readbook.pojo.VoteBook;

public interface VoteService {

	void addVoteBook(VoteBook voteBook);

	VoteBook getVoteBookById(String voteId);

	void deleteVoteBook(String voteBookId);

	void updateVoteBook(VoteBook voteBook);

	List<VoteBook> getVoteBooks();

}
