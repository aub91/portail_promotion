package fr.afcepf.al32.groupe2.dao;


import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.SalesUnit;

@Transactional
@Component
public class SalesUnitJpaDao implements ISalesUnitDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	public SalesUnit findOne(Long id) {
		return entityManager.find(SalesUnit.class, id);
	}
	
	@Override 
	public SalesUnit createOne(SalesUnit salesUnit) {
		entityManager.persist(salesUnit);
		return salesUnit;
	}
	
}
