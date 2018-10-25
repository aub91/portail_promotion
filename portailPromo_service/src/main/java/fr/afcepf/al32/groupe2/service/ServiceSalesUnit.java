package fr.afcepf.al32.groupe2.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.ISalesUnitDao;
import fr.afcepf.al32.groupe2.entity.SalesUnit;


@Transactional
@Component
public class ServiceSalesUnit implements IserviceSalesUnit {
	
	@Autowired
	private ISalesUnitDao salesUnitDao;

	@Override
	public SalesUnit rechercheUniteDeVenteParIdentifiant(Long id) {
		
		return salesUnitDao.findOne(id);
	}

	@Override
	public SalesUnit ajouterSalesUnit(SalesUnit salesUnit) {
		
		salesUnitDao.createOne(salesUnit);
	
		return salesUnit;
	
	}

	@Override
	public List<SalesUnit> findAll() {
		return salesUnitDao.findAll();
	}
	
}
