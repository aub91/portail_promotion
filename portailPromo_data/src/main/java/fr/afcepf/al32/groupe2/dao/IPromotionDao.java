package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Promotion;

public interface IPromotionDao {
	Promotion findOne(Long idUnite);
	List<Promotion> findAll();
	List<Promotion> findAllValid();
	void createOne(Promotion promotion);
}
