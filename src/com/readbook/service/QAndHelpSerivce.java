package com.readbook.service;

import java.util.List;

import com.readbook.pojo.RbQanda;

public interface QAndHelpSerivce {

	List<RbQanda> getHelps();

	void addQanda(RbQanda rbQanda);

	void deleteHelpById(String helpId);

}
