package fr.afcepf.al32.groupe2.service;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;


public interface IServiceCategoryProduct {
	CategoryProduct  rechercheCategoryProduitParIdentifiant(Long id) ;
}
