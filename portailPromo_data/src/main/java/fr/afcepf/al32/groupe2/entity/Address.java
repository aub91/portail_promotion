package fr.afcepf.al32.groupe2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="number")
	@NotNull
	private Integer number;
	
	@ManyToOne(cascade= {CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name="address_type_id")
	@NotNull
	private AddressType addressType;
	
	@Column(name="address_complement")
	private String complement;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="city_id")
	@NotNull
	private City city;
	
	@OneToOne(mappedBy="address")
	private Client inhabitant;
	
	@OneToOne(mappedBy="address")
	private Shop shop;
	
	@OneToOne(mappedBy="address", cascade=CascadeType.ALL)
	@NotNull
	private GeographicCoordinates coordinates;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client getInhabitant() {
		return inhabitant;
	}

	public Long getId() {
		return id;
	}
	
	public GeographicCoordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GeographicCoordinates coordinates) {
		this.coordinates = coordinates;
	}


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Shop getShop() {
		return shop;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
}
