package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "percent_type")
@PrimaryKeyJoinColumn(name = "id")
public class PercentType extends PromotionType {

	@Column(name = "percent_value")
	@NotNull
	private Double percentValue;

	@Column(name = "min_purchase_amount")
	private Double minPurchaseAmount;

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

	@Override
	public String getType() {
		return "promotion en percentage";
	}


	@Override
	public Double getPriceAfterPromotion(Double initPrice) {
		return initPrice * (1 - percentValue/100);
	}

}
