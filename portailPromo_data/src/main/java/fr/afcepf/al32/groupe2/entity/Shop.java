package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.afcepf.al32.groupe2.util.FollowableElementType;

@Entity
@Table(name="shop")
public class Shop implements IFollowableElement{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="siret_number")
    @Size(min = 14, max = 14, message = "Siret number must have 14 numbers")
	@NotBlank
	private String siretNumber;
	
	@ManyToOne(cascade= {CascadeType.ALL}, optional=false)
	@JoinColumn(name="company_type_id")
	@NotNull
	private CompanyType companyType;
	
	@Column(name="capital")
	private Double capital;
	
	@Column(name="name")
	@Max(value = 50, message ="size max 50 characters")
	@NotBlank
	private String name;
	
	@Column(name="description")
	@Max(value = 500, message = "size max 500 characters")
	private String description;
	
	@Column(name="image")
	@Max(value = 50, message ="size max 50 characters for picture name")
	private String image;
	
	@Column(name="website_url")
	@Max(value = 50, message ="size max 50 characters")
	private String websiteUrl;
	
	@ManyToOne
	@JoinTable(name="shopkeeper_shop", joinColumns=@JoinColumn(name="shop_id"), inverseJoinColumns=@JoinColumn(name="shopkeeper_id"))
	@NotNull
	private Shopkeeper owner;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="shop_address", joinColumns=@JoinColumn(name="shop_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="shop_id")
	@MapKey(name="id")
	private Map<Long, ShopRegistration> registrations;

	@ManyToMany(mappedBy="shops", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long, Promotion> promotions;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="shop_category_product", joinColumns=@JoinColumn(name="shop_id"), inverseJoinColumns=@JoinColumn(name="category_product_id"))
	@MapKey(name="id")
	private Map<Long, CategoryProduct> categoryProducts;
	
	public String getSiretNumber() {
		return siretNumber;
	}

	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public Shopkeeper getOwner() {
		return owner;
	}

	public void setOwner(Shopkeeper owner) {
		this.owner = owner;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public Map<Long, ShopRegistration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Map<Long, ShopRegistration> registrations) {
		this.registrations = registrations;
	}

	public Map<Long, Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Map<Long, Promotion> promotions) {
		this.promotions = promotions;
	}

	@Override
	public String getType() {
		return FollowableElementType.SHOP;
	}

	public Map<Long, CategoryProduct> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(Map<Long, CategoryProduct> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}
}
