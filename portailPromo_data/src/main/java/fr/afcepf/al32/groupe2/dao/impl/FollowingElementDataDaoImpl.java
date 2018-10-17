package fr.afcepf.al32.groupe2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;

@Transactional
@Repository
public class FollowingElementDataDaoImpl implements FollowingElementDataDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<FollowingElementData> getAllByUser(Long userId) {
		
		return em.createNamedQuery("FollowingElementData.getAllCurrentByUser", FollowingElementData.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<FollowingElementData> getAllByUserAndElementType(Long userId, String type) {
		return em.createNamedQuery("FollowingElementData.getAllCurrentByUserAndElementType", FollowingElementData.class).setParameter("userId", userId).setParameter("type", type).getResultList();
	}

	@Override
	public FollowingElementData save(FollowingElementData fed) {
		em.persist(fed);
		return fed;
	}

}
