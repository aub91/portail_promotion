package fr.afcepf.al32.groupe2.entity;

import java.time.Duration;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="promotion")
public class Promotion extends AbstractPromotion {

	@Column(name="name")
	@NotBlank
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="date_of_creation")
	@NotNull
	private Date dateCreation;
	@Column(name="date_of_remove")
	private Date dateRemove;
	@Column(name="limit_time_promotion")
	@NotNull
	private Duration LimitTimePromotion;
	@Column(name="limit_time_take_promtion")
	@NotNull
	private Duration limitTimeTakePromotion;
	@Column(name="quantity_init_available")
	@NotNull
	private Double quantityInitAvailable;
	@Column(name="quantity_remaining")
	private Double quantityRemaining;
	@Column(name="is_cumulative")
	@NotNull
	private Boolean isCumulative;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateRemove() {
		return dateRemove;
	}
	public void setDateRemove(Date dateRemove) {
		this.dateRemove = dateRemove;
	}
	public Duration getLimitTimePromotion() {
		return LimitTimePromotion;
	}
	public void setLimitTimePromotion(Duration limitTimePromotion) {
		LimitTimePromotion = limitTimePromotion;
	}
	public Duration getLimitTimeTakePromotion() {
		return limitTimeTakePromotion;
	}
	public void setLimitTimeTakePromotion(Duration limitTimeTakePromotion) {
		this.limitTimeTakePromotion = limitTimeTakePromotion;
	}
	public Double getQuantityInitAvailable() {
		return quantityInitAvailable;
	}
	public void setQuantityInitAvailable(Double quantityInitAvailable) {
		this.quantityInitAvailable = quantityInitAvailable;
	}
	public Double getQuantityRemaining() {
		return quantityRemaining;
	}
	public void setQuantityRemaining(Double quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}
	public Boolean getIsCumulative() {
		return isCumulative;
	}
	public void setIsCumulative(Boolean isCumulative) {
		this.isCumulative = isCumulative;
	}

}
