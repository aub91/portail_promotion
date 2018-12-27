package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Client;


public interface IServiceCategoryProduct {
	CategoryProduct  rechercheCategoryProduitParIdentifiant(Long id) ;
	
	List<CategoryProduct> getAllRootCategories();
	
	List<CategoryProduct> getAllRootCategoriesWithDaughters();

	CategoryProduct getCategoryOfLastReservation(Client client);
}
