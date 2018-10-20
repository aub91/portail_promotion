package fr.afcepf.al32.groupe2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IPromotionDao;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.service.IServicePromotion;

@Component
@Transactional
public class ServicePromotion implements IServicePromotion{

	@Autowired
	private IPromotionDao promotionDao;
	
	@Override
	public List<Promotion> findAllValid() {
		// TODO Auto-generated method stub
		return promotionDao.findAllValid();
	}
	
}
