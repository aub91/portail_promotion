package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("client")
public class Client extends User implements ISubscriber{

	@OneToOne(cascade= {CascadeType.ALL})
	@JoinTable(name="client_address", joinColumns=@JoinColumn(name="client_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
	private Address address;
	@OneToMany(mappedBy="client")
	@MapKey(name="id")
	private Map<Long,Reservation> reservations;
}
