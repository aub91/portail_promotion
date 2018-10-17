package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="promotion_product")
public abstract class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name="reference_product_id")	
	@ManyToOne
	private ReferenceProduct referenceProduct;
	
	@OneToOne(mappedBy="productWithPromotion")
	private Promotion promotion;

	public Long getId() {
		return id;
	}
	
	
}
