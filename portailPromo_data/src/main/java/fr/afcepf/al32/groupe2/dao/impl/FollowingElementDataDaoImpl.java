package fr.afcepf.al32.groupe2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.ISubscriber;
import fr.afcepf.al32.groupe2.util.SubscriberType;

@Transactional
@Repository
public class FollowingElementDataDaoImpl implements FollowingElementDataDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<FollowingElementData> getAllByUser(ISubscriber subscriber) {
		Long userId = 0L;
		if(subscriber.getType().equals(SubscriberType.CLIENT)) {
			Client client = (Client) subscriber;
			userId = client.getId();
		}
		return em.createNamedQuery("FollowingElementData.getAllCurrentByUser", FollowingElementData.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<FollowingElementData> getAllByUserAndElementType(ISubscriber subscriber, String type) {
		Long userId = 0L;
		if(subscriber.getType().equals(SubscriberType.CLIENT)) {
			Client client = (Client) subscriber;
			userId = client.getId();
		}
		return em.createNamedQuery("FollowingElementData.getAllCurrentByUserAndElementType", FollowingElementData.class).setParameter("userId", userId).setParameter("type", type).getResultList();
	}

	@Override
	public FollowingElementData save(FollowingElementData fed) {
		if(fed.getId() == null) {
			em.persist(fed);
		}
		else {
			em.merge(fed);
		}
		return fed;
	}

	@Override
	public FollowingElementData getOne(Long id) {
		return em.find(FollowingElementData.class, id);
	}

}
