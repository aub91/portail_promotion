package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sales_unit")
@NamedQueries({
	@NamedQuery(name="SalesUnit.findAll" , query="select s From SalesUnit s" )
	//,@NamedQuery(name="sales_unit.findbySalesUnit" , query="select s From sales_unit s" )
})
public class SalesUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	@NotBlank
	private String name;
	
	@OneToMany(mappedBy = "salesUnit", cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<Long, ReferenceProduct> referenceProduit;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<Long, ReferenceProduct> getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(Map<Long, ReferenceProduct> referenceProduit) {
		this.referenceProduit = referenceProduit;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
