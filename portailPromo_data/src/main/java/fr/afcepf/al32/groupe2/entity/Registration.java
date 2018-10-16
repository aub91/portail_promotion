package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Registration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="registration_date")
	private Date registrationDate;
	
	@Column(name="deregistration_date")
	private Date deregistrationDate;

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getDeregistrationDate() {
		return deregistrationDate;
	}

	public void setDeregistrationDate(Date deregistrationDate) {
		this.deregistrationDate = deregistrationDate;
	}

	public Long getId() {
		return id;
	}
	
}
