package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="reason_cancel_publish_promotion")
public class ReasonCancelPublishPromotion {

	@Id
	private Long id;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	
}
