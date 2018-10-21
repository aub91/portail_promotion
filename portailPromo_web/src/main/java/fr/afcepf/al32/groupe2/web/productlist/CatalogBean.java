package fr.afcepf.al32.groupe2.web.productlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.service.ICatalogService;

@Component
@RequestScope
public class CatalogBean {
	
	@Autowired
	private ICatalogService catalogService;

	private List<Promotion> promotions = new ArrayList<>();
	
	private List<CategoryProduct> categories;
	
	private CategoryProduct selectedCategory;
	
	private String searchField;
	
	public CatalogBean() {
		
	}
	
	public String search() {
		List<String> keyWords = Arrays.asList(searchField.split(" "));
		if(!keyWords.isEmpty()) {
			promotions = catalogService.searchByCategoryAndKeyWords(selectedCategory, keyWords);
		} else if (selectedCategory != null) {
			searchByCategory(selectedCategory);
		}
		return "/invite/fichesPromotion/pageAffichagePromotions";
	}
	
	public String searchByCategory(CategoryProduct category) {
		if(category != null) {
			promotions = catalogService.searchByCategory(category);
		}
		return "/invite/fichesPromotion/pageAffichagePromotions";
	}
	
	@PostConstruct
	public void initCatalogProduits() {
		
		promotions = getAllPromotions();
		
		categories = getAllRootCategories().stream().sorted(Comparator.comparing(CategoryProduct::getName)).collect(Collectors.toList());
	}
	 
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	public List<Promotion> getAllPromotions(){
		return catalogService.getAllDisplayablePromotion();
	}
	
	public List<CategoryProduct> getAllRootCategories(){
		return catalogService.getAllRootCategories();
	}

	public List<CategoryProduct> getCategories() {
		return categories;
	}

	public CategoryProduct getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(CategoryProduct selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	
	
}