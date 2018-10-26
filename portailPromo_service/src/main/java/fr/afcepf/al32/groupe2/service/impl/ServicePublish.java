package fr.afcepf.al32.groupe2.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IPublishDao;
import fr.afcepf.al32.groupe2.entity.Publish;
import fr.afcepf.al32.groupe2.service.IServicePublish;

@Component
@Transactional
public class ServicePublish implements IServicePublish{

	@Autowired
	private IPublishDao publishDao;
	
	@Override
	public Publish create(Publish publish) {
		return publishDao.save(publish);
	}

}
