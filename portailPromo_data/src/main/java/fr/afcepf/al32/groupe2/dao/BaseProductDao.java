package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.BaseProduct;


@Transactional
@Component
public class BaseProductDao implements IBaseProductDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public BaseProduct findOne(Long idUnite) {
	return entityManager.find(BaseProduct.class, idUnite);
		
	}

	@Override
	public BaseProduct createOne(BaseProduct baseProduct) {
		entityManager.persist(baseProduct);
		return baseProduct;
		
	}

	@Override
	public List<BaseProduct> findAll() {
		return entityManager.createNamedQuery("BaseProduct.findAll",BaseProduct.class).getResultList();
	
	}

	@Override
	public List<BaseProduct> findAllValid() {
		return entityManager.createNamedQuery("BaseProduct.findAllValid",BaseProduct.class).getResultList();
	}
	

}
