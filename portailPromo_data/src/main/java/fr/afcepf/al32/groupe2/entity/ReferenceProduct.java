package fr.afcepf.al32.groupe2.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import fr.afcepf.al32.groupe2.util.FollowableElementType;

@Entity
@Table(name = "reference_product")
public class ReferenceProduct implements IFollowableElement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	@NotBlank
	private String name;

	@Column(name = "date_referencing")
	@NotNull
	private Date dateReferencing;

	@Column(name = "date_derefencing")
	private Date dateDerefencing;

	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "sales_unit_id")
	@NotNull
	private SalesUnit salesUnit;

	@ManyToOne(cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "category_produit_id")
	@NotNull
	private CategoryProduct categoriesProduct;

	@OneToMany(mappedBy = "referenceProduct", cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<Long, BaseProduct> listproduct;

	public Date getDateReferencing() {
		return dateReferencing;
	}

	public void setDateReferencing(Date dateReferencing) {
		this.dateReferencing = dateReferencing;
	}

	public Date getDateDeferencing() {

		return dateDerefencing;
	}

	public void setDateDeferencing(Date dateDeferencing) {

		this.dateDerefencing = dateDeferencing;
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

	@Override
	public String getType() {
		return FollowableElementType.REFERENCE;
	}

	public SalesUnit getSalesUnit() {
		return salesUnit;
	}

	public void setSalesUnit(SalesUnit salesUnit) {
		this.salesUnit = salesUnit;
	}

	public CategoryProduct getCategoriesProduct() {
		return categoriesProduct;
	}

	public void setCategoriesProduct(CategoryProduct categoriesProduct) {
		this.categoriesProduct = categoriesProduct;
	}

	public Map<Long, BaseProduct> getListproduct() {
		return listproduct;
	}

	public void setListproduct(Map<Long, BaseProduct> listproduct) {
		this.listproduct = listproduct;
	}

}
