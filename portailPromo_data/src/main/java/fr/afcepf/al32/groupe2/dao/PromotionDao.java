package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.Promotion;

@Component
@Transactional
public class PromotionDao implements IPromotionDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Promotion findOne(Long numero) {
		return em.find(Promotion.class, numero);
	}

	@Override
	public void save(Promotion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findAllValid() {
		
		return em.createNamedQuery("Promotion.findAllValid", Promotion.class).getResultList();
	}

}
