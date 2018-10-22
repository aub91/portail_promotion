package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.afcepf.al32.groupe2.util.SubscriberType;


@Entity
@DiscriminatorValue("client")
@NamedNativeQueries(value= {
		@NamedNativeQuery(name="Client.findAllFollowingFollowableElement", 
				query="SELECT cli.id, cli.first_name, cli.last_name, cli.phone_number, cli.email, client_address.address_id FROM core_user as cli INNER JOIN client_address ON client_address.client_id = cli.id INNER JOIN following_element_data as fed ON cli.id = fed.subscriber_id "
						+ "WHERE fed.element_id = :elementId AND fed.element_type = :elementType AND fed.follow_end_date IS NULL",resultClass=Client.class)
		
})
public class Client extends User implements ISubscriber{

	@OneToOne(cascade= {CascadeType.ALL})
	@JoinTable(name="client_address", joinColumns=@JoinColumn(name="client_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
	private Address address;
	
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	@MapKey(name="id")
	private Map<Long,Reservation> reservations;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<Long, Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Map<Long, Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@Override
	public String getType() {
		return SubscriberType.CLIENT;
	}

}
