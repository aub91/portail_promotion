package fr.afcepf.al32.groupe2.dao;


import java.util.List;

import fr.afcepf.al32.groupe2.entity.SalesUnit;


public interface ISalesUnitDao {
	
	SalesUnit findOne(Long idUnite);
	SalesUnit createOne(SalesUnit salesUnit);
	List<SalesUnit> findAll();
	
}
