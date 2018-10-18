package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="postal_code")
	@NotBlank
	private String postalCode;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	@OneToMany(mappedBy="city", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long, Address> addresses;
	
	

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Long, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<Long, Address> addresses) {
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}
	
}
