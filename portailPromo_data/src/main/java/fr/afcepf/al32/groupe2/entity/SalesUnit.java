package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="sales_unit")
public class SalesUnit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	@NotBlank
	private String name;	
	@OneToMany(mappedBy="uniteVente", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long,ReferenceProduct> referenceProduit;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
