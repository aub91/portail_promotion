package fr.afcepf.al32.groupe2.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import fr.afcepf.al32.groupe2.util.FollowableElementType;

@Entity
@Table(name = "category_product")
@NamedQueries({
	@NamedQuery(name="CategoryProduct.findAllRootCategories" , query="SELECT cat FROM CategoryProduct cat WHERE cat.categoryMum = null" )
})
public class CategoryProduct implements IFollowableElement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	@NotBlank
	private String name;

	@ManyToOne
	@JoinColumn(name = "category_mum_id")
	private CategoryProduct categoryMum;

	@OneToMany(mappedBy = "categoryMum", fetch=FetchType.EAGER)
	private List<CategoryProduct> categoryDaughter;

	@OneToMany(mappedBy = "categoriesProduct", cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<Long, ReferenceProduct> referenceProduit;

	 @ManyToMany(mappedBy="categoryProducts")
	 @MapKey(name="id")
	 private Map<Long, Shop> shops;

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
	public String getType() {
		return FollowableElementType.CATEGORY;
	}

}
