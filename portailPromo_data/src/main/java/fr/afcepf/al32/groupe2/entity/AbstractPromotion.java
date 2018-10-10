package fr.afcepf.al32.groupe2.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class AbstractPromotion extends PromotionProduct {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="promotion_id")
	private PromotionProduct productWithPromotion;

	public PromotionProduct getProductWithPromotion() {
		return productWithPromotion;
	}

	public void setProductWithPromotion(PromotionProduct productWithPromotion) {
		this.productWithPromotion = productWithPromotion;
	}

	
	
	
}
