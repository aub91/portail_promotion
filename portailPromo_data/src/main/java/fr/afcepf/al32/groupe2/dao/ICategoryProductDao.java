package fr.afcepf.al32.groupe2.dao;

import java.util.Map;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;	
	


public interface ICategoryProductDao {
	CategoryProduct findOne(Long idcategorie);
	

}
