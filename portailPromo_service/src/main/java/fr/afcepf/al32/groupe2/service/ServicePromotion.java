package fr.afcepf.al32.groupe2.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IPromotionDao;
import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Promotion;

@Transactional
@Component
public class ServicePromotion implements IServicePromotion {
	@Autowired
	private IPromotionDao promotiondao;

	@Override
	public List<Promotion> findAll() {
		return promotiondao.findAll();
	}

	@Override
	public List<Promotion> findAllValid() {
		return promotiondao.findAllValid();
	}

	@Override
	public List<Promotion> findAllValidByIds(List<Long> ids) {
		return promotiondao.findAllValidByIds(ids);
	}

	@Override
	public Promotion recherchePromotionParIdentifiant(Long idUnite) {
	
		return promotiondao.findOne(idUnite);
	}

	@Override
	public Promotion ajouterPromotion(Promotion promotion) {
		promotiondao.createOne(promotion);
		return promotion;
	}

	@Override
	public List<Promotion> getAllValidPromotionByProduct(List<BaseProduct> products) {
		List<Promotion> validPromos = promotiondao.findAllValid();
		
		List<Promotion> result = new ArrayList<>();
		
		for (Promotion promotion : validPromos) {
			for (BaseProduct product : products) {
				if(product.getId().equals(promotion.getBaseProduct().getId())) {
					result.add(promotion);
					break;
				}
			}
		}
		
		return result;
	}

}
