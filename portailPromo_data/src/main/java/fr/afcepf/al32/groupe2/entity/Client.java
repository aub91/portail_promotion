package fr.afcepf.al32.groupe2.entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.util.FollowableElementType;

@Entity
@DiscriminatorValue("client")
public class Client extends User implements ISubscriber{

	@OneToOne(cascade= {CascadeType.ALL})
	@JoinTable(name="client_address", joinColumns=@JoinColumn(name="client_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
	private Address address;
	
	@OneToMany(mappedBy="client")
	@MapKey(name="id")
	private Map<Long,Reservation> reservations;
	
	@Autowired
	@Transient
	private FollowingElementDataDao followedElementDao;
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Long, FollowingElementData> getAllFollowableElementData() {
		List<FollowingElementData> res = followedElementDao.getAllByUser(getId());
		return res.stream().collect(Collectors.toMap(FollowingElementData::getId, element -> element));
	}



	@Override
	public Map<Long, FollowingElementData> getAllFollowableElementDataByElementType(FollowableElementType type) {
		List<FollowingElementData> res = followedElementDao.getAllByUserAndElementType(getId(), type);
		return res.stream().collect(Collectors.toMap(FollowingElementData::getId, element -> element));
	}
	
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
	
	

}
