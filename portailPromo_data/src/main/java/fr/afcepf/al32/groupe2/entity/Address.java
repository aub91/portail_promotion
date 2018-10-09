package fr.afcepf.al32.groupe2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer number;
	
	@Column(name="address_type")
	private String type;
	
	@Column(name="address_complement")
	private String complement;
	
	private String name;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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




	@Entity
	@Table(name="geographic_coordinates")
	private class GeographicCoordinates {
		
		@Id
		private Long id;
		
		@NotBlank
		private String longitude;
		
		@NotBlank
		private String latitude;
		
		@OneToOne
		@PrimaryKeyJoinColumn
		private Address address;

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
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
	
	
}
