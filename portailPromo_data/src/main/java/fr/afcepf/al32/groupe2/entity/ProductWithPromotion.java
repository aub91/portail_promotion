package fr.afcepf.al32.groupe2.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class ProductWithPromotion extends Product {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="promotion_id")
	private Product productWithPromotion;

	public Product getProductWithPromotion() {
		return productWithPromotion;
	}

	public void setProductWithPromotion(Product productWithPromotion) {
		this.productWithPromotion = productWithPromotion;
	}

	
	
	
}
