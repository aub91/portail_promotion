package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.afcepf.al32.groupe2.util.FollowableElementType;

@Entity
@Table(name="base_product")
@NamedQueries({
	@NamedQuery(name="BaseProduct.findAll" , query="select s From BaseProduct s" )
	//,@NamedQuery(name="sales_unit.findbySalesUnit" , query="select s From sales_unit s" )
})
public class BaseProduct extends Product implements IFollowableElement {
	
	@Column(name="init_price")
	@NotNull
	private Double initPrice;
	@Column(name="description")
	private String description;
	@Column(name="image")
	private String image;
	@Column(name="add_date")
	@NotNull
	private Date addDate;
	@Column(name="remove_date")
	private Date removeDate;
	
	@ManyToOne(cascade= {CascadeType.MERGE}, optional=false)
	@JoinColumn(name="reference_product_id")
	@NotNull
	private ReferenceProduct referenceProduct;
	
	public Double getInitPrice() {
		return initPrice;
	}
	public void setInitPrice(Double initPrice) {
		this.initPrice = initPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}
	public ReferenceProduct getReferenceProduct() {
		return referenceProduct;
	}
	public void setReferenceProduct(ReferenceProduct referenceProduct) {
		this.referenceProduct = referenceProduct;
	}
	
	
	@Override
	public String getType() {
		return FollowableElementType.PRODUCT;
	}


}
