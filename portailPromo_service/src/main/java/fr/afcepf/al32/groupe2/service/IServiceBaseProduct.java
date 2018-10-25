package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.BaseProduct;

public interface IServiceBaseProduct {
	
	
	List<BaseProduct> findAll();
	List<BaseProduct> findAllValid();
	BaseProduct rechercheBaseProductParIdentifiant(Long idUnite);
	BaseProduct ajouterBaseProduct(BaseProduct baseProduct);
}
