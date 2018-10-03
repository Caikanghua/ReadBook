package com.readbook.service;

import java.util.List;

import com.readbook.pojo.RbCarousel;
import com.readbook.pojo.RbPush;

public interface RbCarouselService {

	void addRbCarousel(RbCarousel rbCarousel);

	void deleteCarousel(int carouselId);

	List<RbCarousel> getCarousel(String number);

	void changeToShow(int i);


}
