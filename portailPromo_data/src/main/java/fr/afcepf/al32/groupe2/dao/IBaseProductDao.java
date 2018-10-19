package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.BaseProduct;

public interface IBaseProductDao {
	BaseProduct findOne(Long idUnite);
	BaseProduct createOne(BaseProduct baseProduct);
	List<BaseProduct> findAll();
	List<BaseProduct> findAllValid();
}
