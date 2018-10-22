package fr.afcepf.al32.groupe2.web.addpromotion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.PercentType;
import fr.afcepf.al32.groupe2.entity.Product;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.entity.Publish;
import fr.afcepf.al32.groupe2.entity.Shop;
import fr.afcepf.al32.groupe2.entity.Shopkeeper;
import fr.afcepf.al32.groupe2.service.IFollowableElementService;
import fr.afcepf.al32.groupe2.service.IServiceBaseProduct;
import fr.afcepf.al32.groupe2.service.IServicePromotion;
import fr.afcepf.al32.groupe2.service.IServicePublish;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;

@Component
@RequestScope
@Transactional
public class AddPromotionBean {

	@Autowired
	private ConnectionBean connectionBean;
	
	@Autowired
	private IServicePublish servicePublish;
	
	@Autowired
	private IServiceBaseProduct serviceBaseProduct;
	
	@Autowired
	private IFollowableElementService followableElementService;
	
	private Promotion promotion = new Promotion();
	
	private Long productId;
	
	private String typePromotion;
	
	private Double percentValue;
	
	private Double minPurchaseAmount;
	
	private Long commerceId;
	
	private List<Shop> shops;
	
	private List<BaseProduct> products;
	
	public void create() {
		BaseProduct baseProduct = serviceBaseProduct.rechercheBaseProductParIdentifiant(productId);
		Product product = baseProduct.getLastProduct();
		promotion.setProduct(product);
		promotion.setDateCreation(new Date());
		promotion.setIsCumulative(false);
		promotion.setLimitTimePromotion(Duration.ofDays(2));
		promotion.setLimitTimeTakePromotion(Duration.ofHours(2));
		promotion.setQuantityRemaining(promotion.getQuantityInitAvailable());
		
		Map<Long, Shop> shopMap = new HashMap<>();
		Shopkeeper shopkeeper = (Shopkeeper) connectionBean.getLoggedUser();
		Shop shop = shopkeeper.getShops().get(commerceId);
		shopMap.put(shop.getId(), shop);
		promotion.setShops(shopMap);
		
		PercentType percentType = new PercentType();
		percentType.setMinPurchaseAmount(minPurchaseAmount);
		percentType.setPercentValue(percentValue);
		
		promotion.setPromotionType(percentType);
		
		Publish publish = new Publish();
		publish.setPublishDate(new Date());
		publish.setPromotion(promotion);
		
		servicePublish.create(publish);
		
		followableElementService.notifySubscribers(shop);
		
	}
	
	@PostConstruct
	public void init() {
		Shopkeeper shopkeeper = (Shopkeeper) connectionBean.getLoggedUser();
		shops = new ArrayList<>(shopkeeper.getShops().values());
		
		products = serviceBaseProduct.findAll();
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public String getTypePromotion() {
		return typePromotion;
	}

	public void setTypePromotion(String typePromotion) {
		this.typePromotion = typePromotion;
	}

	public Double getPercentValue() {
		return percentValue;
	}

	public void setPercentValue(Double percentValue) {
		this.percentValue = percentValue;
	}

	public Double getMinPurchaseAmount() {
		return minPurchaseAmount;
	}

	public void setMinPurchaseAmount(Double minPurchaseAmount) {
		this.minPurchaseAmount = minPurchaseAmount;
	}

	public Long getCommerceId() {
		return commerceId;
	}

	public void setCommerceId(Long commerceId) {
		this.commerceId = commerceId;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public List<BaseProduct> getProducts() {
		return products;
	}

	public void setProducts(List<BaseProduct> products) {
		this.products = products;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	
}
