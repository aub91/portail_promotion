package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Promotion;

public interface IServicePromotion {
	List<Promotion> findAll();
	List<Promotion> findAllValid();
	Promotion recherchePromotionParIdentifiant(Long idUnite);
	Promotion AjouterPromotion(Promotion promotion);

}
