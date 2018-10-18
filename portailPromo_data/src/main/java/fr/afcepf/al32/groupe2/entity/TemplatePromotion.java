package fr.afcepf.al32.groupe2.entity;

import java.time.Duration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="template_promotion")
public class TemplatePromotion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="promotion_time")
	@NotNull
	private Duration promotionTime;
	
	@Column(name="promotion_time_to_take_out")
	@NotNull
	private Duration promotionTimeToTakeOut;
	
	@ManyToOne(cascade= {CascadeType.ALL}, optional=false)
	@JoinColumn(name="promotion_type_id")
	@NotNull
	private PromotionType promotionType;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="shopkeeper_id")
	private Shopkeeper owner;
	
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
	public PromotionType getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}
	public Shopkeeper getOwner() {
		return owner;
	}
	public void setOwner(Shopkeeper owner) {
		this.owner = owner;
	}
	
	
	
}
