package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbGoodbookMapper;
import com.readbook.pojo.RbGoodbook;
import com.readbook.pojo.RbGoodbookExample;
import com.readbook.service.RbGoodbookService;
@Service
public class RbGoodbookServiceImpl implements RbGoodbookService {
	@Autowired
	private RbGoodbookMapper rbGoodbookMapper;
	@Override
	public List<RbGoodbook> getGoodBooks() {
		RbGoodbookExample example=new RbGoodbookExample();
		return rbGoodbookMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public void addGoodbook(RbGoodbook rbGoodbook) {
		 rbGoodbookMapper.insertSelective(rbGoodbook);
	}
	@Override
	public void deleteGoodBookById(String goodBookId) {
		rbGoodbookMapper.deleteByPrimaryKey(Integer.parseInt(goodBookId));
	}

}
