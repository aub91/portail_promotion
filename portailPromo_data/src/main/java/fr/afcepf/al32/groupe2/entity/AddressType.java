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
@Table(name="address_type")
public class AddressType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private double id;
	
	@Column(name="name")
	@NotBlank
	private String name;

	@OneToMany(mappedBy="addressType", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long, Address> addresses;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getId() {
		return id;
	}

	public Map<Long, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<Long, Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
