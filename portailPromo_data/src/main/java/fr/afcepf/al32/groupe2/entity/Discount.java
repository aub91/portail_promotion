package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "discount")
@PrimaryKeyJoinColumn(name = "id")
public class Discount extends PromotionType {

	@Column(name = "discount_value")
	@NotNull
	@Min(0)
	private Double discountValue;

	@Column(name = "min_purchase_amount")
	private Double minPurchaseAmount;

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Double getMinPurchaseAmount() {
		return minPurchaseAmount;
	}

	public void setMinPurchaseAmount(Double minPurchaseAmount) {
		this.minPurchaseAmount = minPurchaseAmount;
	}

	@Override
	public String getType() {
		return "promotion discount";

	}

	@Override
	public Double getPriceAfterPromotion(Double initPrice) {
		return initPrice - discountValue;
	}

}
