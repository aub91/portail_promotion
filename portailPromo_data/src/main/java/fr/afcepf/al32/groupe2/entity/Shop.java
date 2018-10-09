package fr.afcepf.al32.groupe2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="siret_number")
	private String siretNumber;
	
	@Column(name="company_type")
	private String companyType;
	
	private Double capital;
	
	private String name;
	
	private String description;
	
	private String image;
	
	@Column(name="website_url")
	private String websiteUrl;
	
	@ManyToOne
	@JoinTable(name="shopkeeper_shop", joinColumns=@JoinColumn(name="shopkeeper_id"), inverseJoinColumns=@JoinColumn(name="shop_id"))
	@NotNull
	private Shopkeeper owner;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="shop_address", joinColumns=@JoinColumn(name="shop_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
	private Address address;

	public String getSiretNumber() {
		return siretNumber;
	}

	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
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
	
	
}
