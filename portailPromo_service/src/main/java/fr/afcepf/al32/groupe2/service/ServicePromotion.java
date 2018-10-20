package fr.afcepf.al32.groupe2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IPromotionDao;
import fr.afcepf.al32.groupe2.entity.Promotion;

@Transactional
@Component
public class ServicePromotion implements IServicePromotion {
	@Autowired
	private IPromotionDao promotiondao;
	
	public ServicePromotion() {
	
	}

	@Override
	public List<Promotion> findAll() {
		return promotiondao.findAll();
	}

	@Override
	public List<Promotion> findAllValid() {
		return promotiondao.findAllValid();
	}

	@Override
	public Promotion recherchePromotionParIdentifiant(Long idUnite) {
	
		return promotiondao.findOne(idUnite);
	}

	@Override
	public Promotion AjouterPromotion(Promotion promotion) {
		promotiondao.createOne(promotion);
		return promotion;
	}

}
