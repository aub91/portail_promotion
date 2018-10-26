package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "promotion_type")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PromotionType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	public Long getId() {
		return id;
	}
	
	public abstract String getType();
	
	public abstract Double getPriceAfterPromotion(Double initPrice);
}
