package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="geographic_coordinates")
public class GeographicCoordinates {
	@Id
	private Long id;
	
	@Column(name="longitude")
	@NotBlank
	private String longitude;
	
	@Column(name="latitude")
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
