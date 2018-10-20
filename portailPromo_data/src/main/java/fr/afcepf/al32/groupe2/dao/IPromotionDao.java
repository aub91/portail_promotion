package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Promotion;

public interface IPromotionDao extends IGenericDao<Promotion> {
	List<Promotion> findAllValid();

	void createOne(Promotion promotion);
}
