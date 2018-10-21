package fr.afcepf.al32.groupe2.service.factory;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.Discount;
import fr.afcepf.al32.groupe2.entity.Pack;
import fr.afcepf.al32.groupe2.entity.PercentType;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.entity.PromotionType;


@Component
public class PromotionFactory implements IPromotionFactory {
	
	@Autowired
	private static PromotionFactory promotionFactory;
	
	@Autowired
	private IPromotionTypeFactory<Pack> typePack;
	
	@Autowired
	private IPromotionTypeFactory<PercentType> typePercentType;
	
	@Autowired
	private IPromotionTypeFactory<Discount> typeDiscount;
	
	private String name;
	private String description;
	private Duration limitTimePromotion;
	private Duration limitTimeTakePromotion;
	private Double quantityInitAvailable;
	private Boolean isCumulative;
	
	private PromotionType promotionType;
	
	public static PromotionFactory getPromotionType() {
		if(promotionFactory == null) {
			promotionFactory = new PromotionFactory();
			promotionFactory.initFactory();
			
		}
		
		return promotionFactory;
	}

	private void initFactory() {
		// TODO Auto-generated method stub
		
	}
	
	public Promotion fabrique() {
		Promotion promotion = new Promotion();
		
		promotion.setName(name);
		promotion.setDescription(description);
		promotion.setLimitTimePromotion(limitTimePromotion);
		promotion.setLimitTimeTakePromotion(limitTimeTakePromotion);
		promotion.setQuantityInitAvailable(quantityInitAvailable);
		promotion.setIsCumulative(isCumulative);
		
		return promotion;	
	}

	public IPromotionTypeFactory<Pack> CreateTypePack() {
		
		return typePack;
	}
	
	public IPromotionTypeFactory<Discount> CreateTypeDiscount() {
		
		return typeDiscount;
	}
	
	public IPromotionTypeFactory<PercentType> CreateTypePercentType() {
		
		return typePercentType;
	}
	
	@Override
	public IPromotionFactory setNamePromotion(String name) {
		this.name = name;
		return this;
	}

	@Override
	public IPromotionFactory setDescriptionPromotion(String description) {
		this.description = description;
		return this;
	}

	@Override
	public IPromotionFactory setLimitTimePromotion(Duration limitTimePromotion) {
		this.limitTimePromotion = limitTimePromotion;
		return this;
	}

	@Override
	public IPromotionFactory setLimitTimeTakePromotion(Duration limitTimeTakePromotion) {
		this.limitTimeTakePromotion = limitTimeTakePromotion;
		return this;
	}

	@Override
	public IPromotionFactory setQuantityInitAvailable(Double quantityInitAvailable) {
		this.quantityInitAvailable = quantityInitAvailable;
		return this;
	}

	@Override
	public IPromotionFactory setIsCumulative(Boolean isCumulative) {
		this.isCumulative = isCumulative;
		return this;
	}

}
