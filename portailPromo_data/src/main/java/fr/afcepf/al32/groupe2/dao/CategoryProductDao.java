package fr.afcepf.al32.groupe2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;

@Transactional
@Component
public class CategoryProductDao implements ICategoryProductDao{
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public CategoryProduct findOne(Long idcategorie) {
		
		return entityManager.find(CategoryProduct.class, idcategorie);
	}

}
