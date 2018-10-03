package com.readbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbCarouselMapper;
import com.readbook.pojo.RbCarousel;
import com.readbook.pojo.RbCarouselExample;
import com.readbook.pojo.RbCarouselExample.Criteria;
import com.readbook.service.RbCarouselService;
import com.readbook.utils.IDUtils;
@Service
public class RbCarouselServiceImpl implements RbCarouselService {
	@Autowired
	private RbCarouselMapper rbCarouselMapper;
	@Override
	public void addRbCarousel(RbCarousel rbCarousel) {
		rbCarousel.setIsDelete(false);
		rbCarousel.setIsShown(true);
		rbCarousel.setUploadDate(new Date());
		rbCarouselMapper.insertSelective(rbCarousel);
	}
	@Override
	public void deleteCarousel(int carouselId) {
		rbCarouselMapper.deleteByPrimaryKey(carouselId);
	}
	@Override
	public List<RbCarousel> getCarousel(String number) {
		List<RbCarousel> list=rbCarouselMapper.getCarouselShow(Integer.parseInt(number));
		return list;
	}
	@Override
	public void changeToShow(int i) {
		rbCarouselMapper.changeToShow(i);
	}

}
