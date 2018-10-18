package fr.afcepf.al32.groupe2.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;

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
	
	
	@OneToMany(mappedBy="categoriesProduit", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long,ReferenceProduct> referenceProduit;
	
//	@ManyToMany(mappedBy="categoryProduct")
//	@MapKey(name="id")
//	private Shop shop;
	
	@Transient
	@Autowired
	private FollowingElementDataDao followingElementDataDao;

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

	
	public Map<Long, ReferenceProduct> getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(Map<Long, ReferenceProduct> referenceProduit) {
		this.referenceProduit = referenceProduit;
	}


	@Override
	public void addSubscriber(ISubscriber subscriber) {
		FollowingElementData followingElementData = new FollowingElementData();
		
		followingElementData.setElement(this);
		followingElementData.setSubscriber(subscriber);
		followingElementData.setFollowStartDate(new Date());
		
		followingElementDataDao.save(followingElementData);
		
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
