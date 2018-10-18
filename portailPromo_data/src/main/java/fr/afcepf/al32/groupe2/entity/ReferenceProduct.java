package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reference_product")
public class ReferenceProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	@Column(name="date_referencing")
	@NotNull
	private Date dateReferencing;
	
	@Column(name="date_derefencing")
	private Date dateDeferencing;
	
	@JoinColumn(name="sales_unit_id")	
	@ManyToOne
	@NotNull
	private SalesUnit salesUnit;
	
	@JoinColumn(name="category_produit_id")	
	@ManyToOne
	@NotNull
	private CategoryProduct categoriesProduit;
	

	public Date getDateReferencing() {
		return dateReferencing;
	}
	public void setDateReferencing(Date dateReferencing) {
		this.dateReferencing = dateReferencing;
	}
	public Date getDateDeferencing() {
		return dateDeferencing;
	}
	public void setDateDeferencing(Date dateDeferencing) {
		this.dateDeferencing = dateDeferencing;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SalesUnit getSalesUnit() {
		return salesUnit;
	}
	public void setSalesUnit(SalesUnit salesUnit) {
		this.salesUnit = salesUnit;
	}
	public CategoryProduct getCategoriesProduit() {
		return categoriesProduit;
	}
	public void setCategoriesProduit(CategoryProduct categoriesProduit) {
		this.categoriesProduit = categoriesProduit;
	}	

}
