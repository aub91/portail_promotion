package fr.afcepf.al32.groupe2.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne(mappedBy="product")
	private Promotion promotion;
	
	public Long getId() {
		return id;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	abstract List<Promotion> getPromotionList();
	
	abstract Double getInitPrice();
	

	public Product getLastProduct() {
		Product result = this;
		if(getPromotion() != null) {
			result=getPromotion().getLastProduct();
		}
		return result;
	}

	abstract BaseProduct getBaseProduct();


}
