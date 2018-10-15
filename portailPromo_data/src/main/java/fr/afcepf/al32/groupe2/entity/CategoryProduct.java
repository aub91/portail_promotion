package fr.afcepf.al32.groupe2.entity;

import java.util.List;
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
@Table(name="category_product")
public class CategoryProduct implements IFollowableElement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	@ManyToOne
	@JoinColumn(name="category_mum_id")
	private CategoryProduct categoryMum;
	
	@OneToMany(mappedBy="categoryMum")
	private List<CategoryProduct> categoryDaughter;
	
	//@JoinColumn(name="reference_produit",)	
	@OneToMany(mappedBy="categorieProduit", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long,ReferenceProduct> referenceProduit;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CategoryProduct getCategoryMum() {
		return categoryMum;
	}

	public List<CategoryProduct> getCategoryDaughter() {
		return categoryDaughter;
	}

	@Override
	public void addSubscriber(ISubscriber subscriber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSubscriber(ISubscriber subscriber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifySubscribers() {
		// TODO Auto-generated method stub
		
	}

	
	

}
