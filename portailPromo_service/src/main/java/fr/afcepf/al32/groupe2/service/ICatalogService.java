package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Promotion;

public interface ICatalogService {
	
	List<Promotion> getAllDisplayablePromotion();
	
	List<CategoryProduct> getAllRootCategories();

	List<Promotion> searchByCategory(CategoryProduct category);

}
