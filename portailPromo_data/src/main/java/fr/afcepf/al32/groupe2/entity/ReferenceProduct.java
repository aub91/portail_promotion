package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reference_product")
public class ReferenceProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	@NotBlank
	private String name;
	@Column(name="date_referencing")
	@NotNull
	private Date dateReferencing;
	@Column(name="date_derefencing")
	private Date dateDeferencing;
	

	public Date getDateReferencing() {
		return dateReferencing;
	}
	public void setDateReferencing(Date dateReferencing) {
		this.dateReferencing = dateReferencing;
	}
	public Date getDateDeferencing() {
		return dateDeferencing;
	}
	public void setDateDeferencing(Date dateDeferencing) {
		this.dateDeferencing = dateDeferencing;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

}
