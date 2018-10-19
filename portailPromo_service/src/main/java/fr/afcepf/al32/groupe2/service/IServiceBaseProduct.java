package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.BaseProduct;

public interface IServiceBaseProduct {
	
	
	List<BaseProduct> findAll();
	BaseProduct rechercheBaseProductParIdentifiant(Long idUnite);
	BaseProduct AjouterBaseProduct(BaseProduct baseProduct);
}
