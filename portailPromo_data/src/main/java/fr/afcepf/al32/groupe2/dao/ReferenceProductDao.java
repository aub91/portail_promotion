package fr.afcepf.al32.groupe2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.ReferenceProduct;

@Transactional
@Component
public class ReferenceProductDao implements IReferenceProductDao{

		@PersistenceContext
		private EntityManager entityManager;

		@Override
		public ReferenceProduct findOne(Long id) {
			
			return entityManager.find(ReferenceProduct.class, id);
				
		}

		@Override
		public ReferenceProduct createOne(ReferenceProduct referenceProduct) {
			entityManager.persist(referenceProduct);
			return referenceProduct;
		}
		
	}



