package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pack")
@PrimaryKeyJoinColumn(name = "id")
public class Pack extends PromotionType {
	
	@Column(name="number_purchased")
	@NotNull
	private Integer numberPurchased;
	
	@Column(name="number_offered")
	@NotNull
	private Integer numberOffered;
	
	
	public Integer getNumberPurchased() {
		return numberPurchased;
	}
	public void setNumberPurchased(Integer numberPurchased) {
		this.numberPurchased = numberPurchased;
	}
	public Integer getNumberOffered() {
		return numberOffered;
	}
	public void setNumberOffered(Integer numberOffered) {
		this.numberOffered = numberOffered;
	}
	@Override
	public Double getPriceAfterPromotion(Double initPrice) {
		return initPrice * numberPurchased/(numberPurchased+numberOffered);
	}
	
	@Override
	public String getType() {
		return "promotion pack";
		
	}
	
}
