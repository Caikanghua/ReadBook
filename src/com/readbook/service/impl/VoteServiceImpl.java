package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.VoteBookMapper;
import com.readbook.pojo.VoteBook;
import com.readbook.pojo.VoteBookExample;
import com.readbook.service.VoteService;
@Service
public class VoteServiceImpl implements VoteService {
	@Autowired
	private VoteBookMapper mapper;
	@Override
	public void addVoteBook(VoteBook voteBook) {
		mapper.insertSelective(voteBook);
	}
	@Override
	public VoteBook getVoteBookById(String voteId) {
		return mapper.selectByPrimaryKey(Integer.parseInt(voteId));
	}
	@Override
	public void deleteVoteBook(String voteBookId) {
		mapper.deleteByPrimaryKey(Integer.parseInt(voteBookId));
	}
	@Override
	public void updateVoteBook(VoteBook voteBook) {
		mapper.updateByPrimaryKeyWithBLOBs(voteBook);
	}
	@Override
	public List<VoteBook> getVoteBooks() {
		VoteBookExample example=new VoteBookExample();
		return mapper.selectByExampleWithBLOBs(example);
	}

}
