package fr.afcepf.al32.groupe2.entity;

import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="template_promotion")
public class TemplatePromotion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="promotion_time")
	
	private Duration promotionTime;
	@Column(name="promotion_time_to_take_out")
	private Duration promotionTimeToTakeOut;
	
	
	public Duration getPromotionTime() {
		return promotionTime;
	}
	public void setPromotionTime(Duration promotionTime) {
		this.promotionTime = promotionTime;
	}
	
	public Duration getPromotionTimeToTakeOut() {
		return promotionTimeToTakeOut;
	}
	public void setPromotionTimeToTakeOut(Duration promotionTimeToTakeOut) {
		this.promotionTimeToTakeOut = promotionTimeToTakeOut;
	}
	public Long getId() {
		return id;
	}
	
}
