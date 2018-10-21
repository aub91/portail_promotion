package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;	
	


public interface ICategoryProductDao {
	CategoryProduct findOne(Long idcategorie);
	
	List<CategoryProduct> findAllRootCategories();

	List<CategoryProduct> findAllRootCategoriesWithDaughters();
	

}
