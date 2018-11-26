package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.Promotion;

@Transactional
@Component
public class PromotionDao implements IPromotionDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Promotion findOne(Long idUnite) {
	return entityManager.find(Promotion.class, idUnite);
	}

	@Override
	public void createOne(Promotion promotion) {
		entityManager.persist(promotion);
	}

	@Override
	public List<Promotion> findAll() {
		
		return entityManager.createNamedQuery("Promotion.findAll",Promotion.class).getResultList();
	}

	@Override
	public List<Promotion> findAllValid() {

		return entityManager.createNamedQuery("Promotion.findAllValid",Promotion.class).getResultList();
	}

	@Override
	public List<Promotion> findAllValidByIds(List<Long> ids) {
		return entityManager.createNamedQuery("Promotion.findAllValidByIds",Promotion.class).setParameter("promoIds", ids).getResultList();
	}

	@Override
	public void save(Promotion p) {
		entityManager.persist(p);
	}

	@Override
	public void delete(Long numero) {
		Promotion p = entityManager.find(Promotion.class, numero);
		entityManager.remove(p);
	}

}
