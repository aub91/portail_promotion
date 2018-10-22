package fr.afcepf.al32.groupe2.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IPublishDao;
import fr.afcepf.al32.groupe2.entity.Publish;

@Component
@Transactional
public class PublishDao implements IPublishDao{

	@PersistenceContext
	private EntityManager em;
	@Override
	public Publish save(Publish publish) {
		em.persist(publish);
		return publish;
	}

}
