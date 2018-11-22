package fr.afcepf.al32.groupe2.web.addpromotion;

import fr.afcepf.al32.groupe2.entity.*;
import fr.afcepf.al32.groupe2.service.IFollowableElementService;
import fr.afcepf.al32.groupe2.service.IServiceBaseProduct;
import fr.afcepf.al32.groupe2.service.IServicePublish;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.Duration;
import java.util.*;

@Component
@SessionScope
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

	/**
	 * Id of the product link to the created promotion
	 */
	private Long productId;

	/**
	 * Type of the promotion.
	 */
	private String typePromotion = "percentage";

	/**
	 * For percent type promotion, value of the percentage of reduction.
	 */
	private Double percentValue;

	/**
	 * For discount type promotion, value of the discount in €.
	 */
	private Double discountValue;

	/**
	 * For discount and percent type promotion, minimum of purchase needed to enjoy the promotion, in €.
	 */
	private Double minPurchaseAmount;

	/**
	 * Initial quantity of product available for the promotion.
	 */
	private Double initQuantityAvailable;

	/**
	 * Name of the promotion.
	 */
	private String promotionName;

	/**
	 * Description of the promotion.
	 */
	private String promotionDescription;

	private Long numberPurchase;

	private Long numberOffered;

	/**
	 * Durée de la promotion en jours.
	 */
	private Long promotionDuration;

	/**
	 * Durée de retrait en heures.
	 */
	private Long productTakeAwayDuration;
	
	private Long commerceId;
	
	private List<Shop> shops;
	
	private List<BaseProduct> products;
	
	public void create() {
		Promotion promotion = new Promotion();
		promotion.setName(promotionName);
		promotion.setDescription(promotionDescription);
		promotion.setQuantityInitAvailable(initQuantityAvailable);
		BaseProduct baseProduct = serviceBaseProduct.rechercheBaseProductParIdentifiant(productId);
		Product product = baseProduct.getLastProduct();
		promotion.setProduct(product);
		promotion.setDateCreation(new Date());
		promotion.setIsCumulative(false);
		promotion.setLimitTimePromotion(Duration.ofDays(promotionDuration));
		promotion.setLimitTimeTakePromotion(Duration.ofHours(productTakeAwayDuration));
		promotion.setQuantityRemaining(promotion.getQuantityInitAvailable());
		
		Map<Long, Shop> shopMap = new HashMap<>();
		Shopkeeper shopkeeper = (Shopkeeper) connectionBean.getLoggedUser();
		Shop shop = shopkeeper.getShops().get(commerceId);
		shopMap.put(shop.getId(), shop);
		promotion.setShops(shopMap);

		switch (typePromotion){
			case "percentage":
				createPercentagePromotion(promotion);
				break;
			case "value":
				createDiscountPromotion(promotion);
				break;
			case "pack":
				createPackPromotion(promotion);
				break;
		}

		Publish publish = new Publish();
		publish.setPublishDate(new Date());
		publish.setPromotion(promotion);
		
		servicePublish.create(publish);
		
		followableElementService.notifySubscribers(shop);
		
	}

	private void createPackPromotion(Promotion promotion) {
		Pack packType = new Pack();
		packType.setNumberPurchased(numberPurchase.intValue());
		packType.setNumberOffered(numberOffered.intValue());
		promotion.setPromotionType(packType);
	}

	private void createDiscountPromotion(Promotion promotion) {
		Discount discountType = new Discount();
		discountType.setDiscountValue(discountValue);
		discountType.setMinPurchaseAmount(minPurchaseAmount);
		promotion.setPromotionType(discountType);
	}

	private void createPercentagePromotion(Promotion promotion) {
		PercentType percentType = new PercentType();
		percentType.setMinPurchaseAmount(minPurchaseAmount);
		percentType.setPercentValue(percentValue);
		promotion.setPromotionType(percentType);
	}

	@PostConstruct
	public void init() {
		Shopkeeper shopkeeper = (Shopkeeper) connectionBean.getLoggedUser();
		shops = new ArrayList<>(shopkeeper.getShops().values());
		
		products = serviceBaseProduct.findAll();
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

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Long getNumberPurchase() {
		return numberPurchase;
	}

	public void setNumberPurchase(Long numberPurchase) {
		this.numberPurchase = numberPurchase;
	}

	public Long getNumberOffered() {
		return numberOffered;
	}

	public void setNumberOffered(Long numberOffered) {
		this.numberOffered = numberOffered;
	}

	public Long getPromotionDuration() {
		return promotionDuration;
	}

	public void setPromotionDuration(Long promotionDuration) {
		this.promotionDuration = promotionDuration;
	}

	public Long getProductTakeAwayDuration() {
		return productTakeAwayDuration;
	}

	public void setProductTakeAwayDuration(Long productTakeAwayDuration) {
		this.productTakeAwayDuration = productTakeAwayDuration;
	}

	public Double getInitQuantityAvailable() {
		return initQuantityAvailable;
	}

	public void setInitQuantityAvailable(Double initQuantityAvailable) {
		this.initQuantityAvailable = initQuantityAvailable;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionDescription() {
		return promotionDescription;
	}

	public void setPromotionDescription(String promotionDescription) {
		this.promotionDescription = promotionDescription;
	}
}
