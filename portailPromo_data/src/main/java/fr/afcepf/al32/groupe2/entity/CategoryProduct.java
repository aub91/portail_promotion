package fr.afcepf.al32.groupe2.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="category_product")
public class CategoryProduct extends AbstractPromotion implements IFollowableElement {
	
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

}
