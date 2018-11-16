package fr.afcepf.al32.groupe2.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="promotion")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
	@NamedQuery(name="Promotion.findAll" , query="select s From Promotion s" ),
	@NamedQuery(name="Promotion.findAllValid" , query="select s From Promotion s WHERE s.dateRemove = null AND quantityRemaining > 0" )
})
public class Promotion extends Product {

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
	private Duration limitTimePromotion;
	@Column(name="limit_time_take_promotion")
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
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="promotion_shop", joinColumns=@JoinColumn(name="promotion_id"),inverseJoinColumns=@JoinColumn(name="shop_id"))
	@MapKey(name="id")
	private Map<Long, Shop> shops;
	
	@OneToOne(mappedBy="promotion",cascade= {CascadeType.ALL}, optional=false)
	@NotNull
	private Publish publish;
	
	@ManyToOne(cascade= {CascadeType.ALL}, optional=false)
	@JoinColumn(name="promotion_type_id")
	@NotNull
	private PromotionType promotionType;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="template_promotion_id")
	private TemplatePromotion templatePromotion;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="product_id")
	private Product product;
	
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
		return limitTimePromotion;
	}
	public void setLimitTimePromotion(Duration limitTimePromotion) {
		this.limitTimePromotion = limitTimePromotion;
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
	public Map<Long, Shop> getShops() {
		return shops;
	}
	public void setShops(Map<Long, Shop> shops) {
		this.shops = shops;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	public PromotionType getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}
	public TemplatePromotion getTemplatePromotion() {
		return templatePromotion;
	}
	public void setTemplatePromotion(TemplatePromotion templatePromotion) {
		this.templatePromotion = templatePromotion;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public List<Promotion> getPromotionList() {
		List<Promotion> result = new ArrayList<>();
		if(getPromotion() != null) {
			result.addAll(getPromotion().getPromotionList());
		}
		if(publish.getPublishDate() != null) {
			LocalDateTime publishTime = publish.getPublishDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			if(LocalDateTime.now().isAfter(publishTime) && LocalDateTime.now().isBefore(publishTime.plus(limitTimePromotion))) {
				result.add(this);
			}
		}
		
		return result;
	}
	
	public Double getPriceAfterPromotion() {
		return promotionType.getPriceAfterPromotion(getInitPrice());
	}
	@Override
	public Double getInitPrice() {
		return getProduct().getInitPrice();
	}	

	@Override
	public BaseProduct getBaseProduct() {
		return getProduct().getBaseProduct();
	}
	
	public List<Shop> getShopList(){
		return new ArrayList<>(getShops().values());
	}
	
	public Date getEndDate() {
		LocalDateTime beginDate = publish.getPublishDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		return Date.from(beginDate.plus(limitTimePromotion).toInstant(ZoneOffset.UTC));
	}


}
