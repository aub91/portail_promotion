package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;


public interface IServiceCategoryProduct {
	CategoryProduct  rechercheCategoryProduitParIdentifiant(Long id) ;
	
	List<CategoryProduct> getAllRootCategories();
	
	List<CategoryProduct> getAllRootCategoriesWithDaughters();
}
